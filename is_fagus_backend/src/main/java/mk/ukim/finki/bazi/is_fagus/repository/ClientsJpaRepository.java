package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ClientsJpaRepository extends JpaRepository<Klienti,Long> {

    Optional<Klienti> findByKorisnickoIme(String username);


}
