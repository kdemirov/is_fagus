package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.EvidencijaNarackiIzraboteniDelovi;
import mk.ukim.finki.bazi.is_fagus.model.EvidencijaNarackiIzraboteniDeloviId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsForDonePartsRepository extends JpaRepository<EvidencijaNarackiIzraboteniDelovi, EvidencijaNarackiIzraboteniDeloviId> {
}
