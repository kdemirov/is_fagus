package mk.ukim.finki.bazi.is_fagus.repository;


import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.ShoppingCart;
import mk.ukim.finki.bazi.is_fagus.model.enumerations.ShoppingCardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findByClientAndAndStatus(Klienti client, ShoppingCardStatus status);
}
