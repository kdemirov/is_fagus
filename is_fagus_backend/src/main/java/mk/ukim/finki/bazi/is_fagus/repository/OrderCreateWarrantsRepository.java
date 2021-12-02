package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.NaloziKreiraNaracka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCreateWarrantsRepository extends JpaRepository<NaloziKreiraNaracka,Long> {
}
