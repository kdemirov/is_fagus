package mk.ukim.finki.bazi.is_fagus.config;

import mk.ukim.finki.bazi.is_fagus.repository.ClientsJpaRepository;
import mk.ukim.finki.bazi.is_fagus.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PasswordEncryptingComponent {

    private final ClientsJpaRepository clientsJpaRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptingComponent(ClientsJpaRepository clientsJpaRepository,
                                       UsersRepository usersRepository,
                                       PasswordEncoder passwordEncoder) {
        this.clientsJpaRepository = clientsJpaRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        this.clientsJpaRepository.findAll()
                .stream()
                .filter(c -> c.getLozinka().length() <= 10)
                .forEach(c -> {
                    c.setLozinka(this.passwordEncoder.encode(c.getLozinka()));
                    this.clientsJpaRepository.save(c);
                });
        this.usersRepository.findAll()
                .stream()
                .filter(u -> u.getLozinka().length() <= 10)
                .forEach(u ->
                {
                    u.setLozinka(this.passwordEncoder.encode(u.getLozinka()));
                    this.usersRepository.save(u);
                });

    }
}
