package mk.ukim.finki.bazi.is_fagus.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.Korisnik;
import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import mk.ukim.finki.bazi.is_fagus.model.dto.ClientDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import mk.ukim.finki.bazi.is_fagus.repository.ClientsJpaRepository;
import mk.ukim.finki.bazi.is_fagus.repository.JwtRepository;
import mk.ukim.finki.bazi.is_fagus.repository.UsersRepository;
import mk.ukim.finki.bazi.is_fagus.service.EmployeeUsersService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final ClientsJpaRepository clientsJpaRepository;
    private final JwtRepository jwtRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeUsersService employeeUsersService;

    public UserServiceImpl(UsersRepository usersRepository,
                           ClientsJpaRepository clientsJpaRepository,
                           JwtRepository jwtRepository,
                           PasswordEncoder passwordEncoder,
                           EmployeeUsersService employeeUsersService) {
        this.usersRepository = usersRepository;
        this.clientsJpaRepository = clientsJpaRepository;
        this.jwtRepository = jwtRepository;
        this.passwordEncoder = passwordEncoder;
        this.employeeUsersService = employeeUsersService;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Korisnik> user = this.usersRepository.findByKorisnickoIme(s);
        Optional<Klienti> client = this.clientsJpaRepository.findByKorisnickoIme(s);
        if (client.isPresent()) {
            return new org.springframework.security.core.userdetails.User(client.get().getKorisnickoIme(),
                    client.get().getLozinka(),
                    Stream.of(new SimpleGrantedAuthority(client.get().getRole()
                            .getAuthority()))
                            .collect(Collectors.toList()));
        } else if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getKorisnickoIme(),
                    user.get().getLozinka(),
                    Stream.of(new SimpleGrantedAuthority(user.get().getRole()
                            .getAuthority()))
                            .collect(Collectors.toList()));

        } else {
            throw new UsernameNotFoundException(s);
        }

    }

    @Override
    public Optional<Korisnik> findByUsername(String username) {

        return this.usersRepository.findByKorisnickoIme(username);
    }

    @Override
    public Optional<Klienti> findClientByUsername(String username) {
        return this.clientsJpaRepository.findByKorisnickoIme(username);
    }

    @Override
    public Optional<UserDetailsDto> getCurrentUser(HttpServletRequest request) throws JsonProcessingException {
        return this.jwtRepository.getCurrentUser(request);
    }

    @Override
    public Optional<Klienti> registerClient(ClientDto clientDto) {
        Klienti clients = new Klienti(clientDto.getName(), clientDto.getSurname(), clientDto.getUsername(),
                this.passwordEncoder.encode(clientDto.getPassword()), clientDto.getPassword());
        return Optional.of(this.clientsJpaRepository.save(clients));
    }
}
