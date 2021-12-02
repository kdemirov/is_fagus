package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.views.OrderPercentDoneView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderPercentDoneViewRepository extends JpaRepository<OrderPercentDoneView,Long> {

    List<OrderPercentDoneView> findAllByClientId(Long clientId);
}
