package mk.ukim.finki.bazi.is_fagus.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.Korisnik;
import mk.ukim.finki.bazi.is_fagus.model.dto.ClientDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    /**
     * @param username
     * @return Optional of Korisnik if the given param exist
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     */
    Optional<Korisnik> findByUsername(String username);

    /**
     * @param username
     * @return Returns optional of Klienti if the given param exist
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     */
    Optional<Klienti> findClientByUsername(String username);

    /**
     * @param request
     * @return currentLoggedInUser
     * @throws JsonProcessingException
     */
    Optional<UserDetailsDto> getCurrentUser(HttpServletRequest request) throws JsonProcessingException;

    /**
     * @param clientDto Data transfer object with the information needed for registering a new Client
     * @return Optional of Klienti if the command is executed successfully
     */
    Optional<Klienti> registerClient(ClientDto clientDto);
}
