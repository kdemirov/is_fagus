package mk.ukim.finki.bazi.is_fagus.repository;


import mk.ukim.finki.bazi.is_fagus.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findByKorisnickoIme(String username);
}
