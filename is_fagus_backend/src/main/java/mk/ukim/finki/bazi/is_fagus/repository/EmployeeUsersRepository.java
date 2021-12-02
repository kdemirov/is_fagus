package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import mk.ukim.finki.bazi.is_fagus.model.VraboteniSeKorisnici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeUsersRepository extends JpaRepository<VraboteniSeKorisnici,Long> {

    Optional<VraboteniSeKorisnici> findByIdKorisnik(Long userId);
}
