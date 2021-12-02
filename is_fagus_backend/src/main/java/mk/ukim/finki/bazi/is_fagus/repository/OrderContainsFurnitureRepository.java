package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.NarackaSeSostoiOdMebel;
import mk.ukim.finki.bazi.is_fagus.model.NarackaSeSostoiOdMebelId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderContainsFurnitureRepository extends JpaRepository<NarackaSeSostoiOdMebel, NarackaSeSostoiOdMebelId> {

    Optional<NarackaSeSostoiOdMebel> findByNaracka_IdNaracka(Long id);
}
