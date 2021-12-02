package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefPartsView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiefPartViewRepository extends JpaRepository<ChiefPartsView,Long> {

    List<ChiefPartsView> findAllByFurnitureId(Long furnitureId);
}
