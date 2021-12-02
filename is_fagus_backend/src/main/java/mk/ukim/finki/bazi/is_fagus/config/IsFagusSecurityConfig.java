package mk.ukim.finki.bazi.is_fagus.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.bazi.is_fagus.config.filters.JWTAuthenticationFilter;
import mk.ukim.finki.bazi.is_fagus.config.filters.JWTAuthorizationFilter;
import mk.ukim.finki.bazi.is_fagus.service.EmployeeUsersService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class IsFagusSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUsernameAndPasswordAuthenticatorProvider usernameAndPasswordAuthenticatorProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final Environment environment;
    private final ObjectMapper objectMapper;
    private final EmployeeUsersService employeeUsersService;

    public IsFagusSecurityConfig(CustomUsernameAndPasswordAuthenticatorProvider usernameAndPasswordAuthenticatorProvider,
                                 PasswordEncoder passwordEncoder,
                                 UserService userService,
                                 Environment environment,
                                 ObjectMapper objectMapper,
                                 EmployeeUsersService employeeUsersService) {
        this.usernameAndPasswordAuthenticatorProvider = usernameAndPasswordAuthenticatorProvider;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.environment = environment;
        this.objectMapper = objectMapper;
        this.employeeUsersService = employeeUsersService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/login", "/api/register/client").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(),
                        this.passwordEncoder, this.userService, this.environment,
                        this.objectMapper, employeeUsersService))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }


}
