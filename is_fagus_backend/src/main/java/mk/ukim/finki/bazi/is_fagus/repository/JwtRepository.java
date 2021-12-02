package mk.ukim.finki.bazi.is_fagus.repository;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.bazi.is_fagus.config.JwtConstants;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Repository
public class JwtRepository {

    public Optional<UserDetailsDto> getCurrentUser(HttpServletRequest request) throws JsonProcessingException {
        String header = request.getHeader(JwtConstants.HEADER);
        String token= header.replace(JwtConstants.TOKEN_PREFIX,"");
        String userJwt= JWT.require(Algorithm.none())
                .build()
                .verify(token)
                .getSubject();
        UserDetailsDto userDetailsDto = new ObjectMapper()
                .readValue(userJwt,UserDetailsDto.class);
        return Optional.of(userDetailsDto);
    }
}
