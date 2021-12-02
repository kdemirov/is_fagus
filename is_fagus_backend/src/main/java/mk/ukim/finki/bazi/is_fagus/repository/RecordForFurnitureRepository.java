package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.EvidencijaSeOdnesuvaNaMebel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordForFurnitureRepository extends JpaRepository<EvidencijaSeOdnesuvaNaMebel,Long> {
}
