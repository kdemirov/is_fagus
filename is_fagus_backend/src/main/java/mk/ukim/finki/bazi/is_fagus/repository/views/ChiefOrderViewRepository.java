package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefOrderView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiefOrderViewRepository  extends JpaRepository<ChiefOrderView,Long> {

    List<ChiefOrderView> findAllByOrderId(Long orderId);
}
