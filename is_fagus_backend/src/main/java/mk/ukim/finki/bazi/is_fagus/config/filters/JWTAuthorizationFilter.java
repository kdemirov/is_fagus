package mk.ukim.finki.bazi.is_fagus.config.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.bazi.is_fagus.config.JwtConstants;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JwtConstants.HEADER);
        if (header == null || !header.startsWith(JwtConstants.TOKEN_PREFIX) ||
                header.replace(JwtConstants.TOKEN_PREFIX, "").equals("")) {
            chain.doFilter(request, response);
            return;

        }
        UsernamePasswordAuthenticationToken token = getToken(header);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getToken(String header) throws JsonProcessingException {
        String user = JWT.require(Algorithm.none())
                .withIssuer("auth0")
                .build()
                .verify(header.replace(JwtConstants.TOKEN_PREFIX, ""))
                .getSubject();
        if (user == null) {
            return null;
        }
        System.out.println(user);
        UserDetailsDto userDetailsDto = new ObjectMapper()
                .readValue(user, UserDetailsDto.class);
        return new UsernamePasswordAuthenticationToken(userDetailsDto.getUsername(), "",
                Collections.singleton(userDetailsDto.getRole()));
    }
}
