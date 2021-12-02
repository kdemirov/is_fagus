package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.DopolniteliDeloviZaNaracka;
import mk.ukim.finki.bazi.is_fagus.model.DopolniteliDeloviZaNarackaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraPartsForOrderRepository extends JpaRepository<DopolniteliDeloviZaNaracka, DopolniteliDeloviZaNarackaId> {
}
