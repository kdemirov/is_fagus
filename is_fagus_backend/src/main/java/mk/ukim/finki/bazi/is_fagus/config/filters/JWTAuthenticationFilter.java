package mk.ukim.finki.bazi.is_fagus.config.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import mk.ukim.finki.bazi.is_fagus.config.JwtConstants;
import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.Korisnik;
import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import mk.ukim.finki.bazi.is_fagus.model.dto.LoginDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import mk.ukim.finki.bazi.is_fagus.service.EmployeeUsersService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final Environment environment;
    private final ObjectMapper objectMapper;
    private final EmployeeUsersService employeeUsersService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,
                                   PasswordEncoder passwordEncoder,
                                   UserService userService,
                                   Environment environment,
                                   ObjectMapper objectMapper,
                                   EmployeeUsersService employeeUsersService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.environment = environment;
        this.objectMapper = objectMapper;
        this.employeeUsersService = employeeUsersService;
        setFilterProcessesUrl("/api/login");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String header = request.getHeader(JwtConstants.HEADER);
        String url = request.getRequestURI();
        if (header != null && header.startsWith(JwtConstants.TOKEN_PREFIX) || url.equals("/api/register/client")) {
            chain.doFilter(request, response);
        } else {
            Authentication auth = this.attemptAuthentication(request, response);
            if (auth != null) {
                this.successfulAuthentication(request, response, chain, auth);
            }
        }
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        LoginDto credentials = null;
        try {
            credentials = this.objectMapper.readValue(request.getInputStream(), LoginDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (credentials == null) {
            return null;
        }
        UserDetails user = userService.loadUserByUsername(credentials.getUsername());
        if (!this.passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Bad Credentials");
        }


        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(),
                credentials.getPassword(), user.getAuthorities()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String username = (String) authResult.getPrincipal();
        Optional<Korisnik> user = this.userService.findByUsername(username);
        Optional<Klienti> clients = this.userService.findClientByUsername(username);
        String token = null;
        if (user.isPresent()) {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(new ObjectMapper().writeValueAsString(
                            new UserDetailsDto(user.get().getIdKorisnik(), "", "",
                                    user.get().getKorisnickoIme(), user.get().getRole())
                    ))
                    .withExpiresAt(new Date(System.currentTimeMillis() + JwtConstants.EXPIRATION_TIME))
                    .sign(Algorithm.none());

        } else if (clients.isPresent()) {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(new ObjectMapper().writeValueAsString(
                            new UserDetailsDto(clients.get().getIdKlient(),
                                    clients.get().getIme(),
                                    clients.get().getPrezime(),
                                    clients.get().getKorisnickoIme(),
                                    clients.get().getRole())
                    ))
                    .withExpiresAt(new Date(System.currentTimeMillis() + JwtConstants.EXPIRATION_TIME))
                    .sign(Algorithm.none());
        } else {
            throw new UsernameNotFoundException((String) authResult.getPrincipal());
        }
        response.addHeader(JwtConstants.HEADER, JwtConstants.TOKEN_PREFIX + token);
        response.getWriter().append(token);
        response.getWriter().flush();

    }
}
