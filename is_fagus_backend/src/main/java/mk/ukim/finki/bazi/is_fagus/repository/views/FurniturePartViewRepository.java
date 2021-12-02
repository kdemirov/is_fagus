package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.FurniturePartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.FurniturePartsViewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurniturePartViewRepository extends JpaRepository<FurniturePartsView, FurniturePartsViewId> {

    List<FurniturePartsView> findAllByFurniturePartsViewId_OrderId(Long orderId);
}
