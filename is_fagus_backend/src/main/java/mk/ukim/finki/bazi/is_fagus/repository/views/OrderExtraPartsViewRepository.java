package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.OrderExtraPartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.FurniturePartsViewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderExtraPartsViewRepository extends JpaRepository<OrderExtraPartsView, FurniturePartsViewId> {

    List<OrderExtraPartsView> findAllByOrderExtraPartsId_OrderId(Long orderId);
}
