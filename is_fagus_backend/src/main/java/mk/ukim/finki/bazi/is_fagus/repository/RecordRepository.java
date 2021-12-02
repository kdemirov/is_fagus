package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.EvidencijaNaNaracki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<EvidencijaNaNaracki,Long> {
}
