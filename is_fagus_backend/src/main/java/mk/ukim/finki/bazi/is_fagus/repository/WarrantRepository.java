package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.Nalozi;
import mk.ukim.finki.bazi.is_fagus.model.projection.WarrantProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarrantRepository extends JpaRepository<Nalozi,Long> {

    @Query("select n.idNalog,n.pocetnaData,n.krajnaData from Nalozi n")
    List<WarrantProjection> fetchAll();
}
