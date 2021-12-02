package mk.ukim.finki.bazi.is_fagus.repository.views;
import mk.ukim.finki.bazi.is_fagus.model.views.OrdersView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersViewRepository extends JpaRepository<OrdersView,Long> {

    List<OrdersView> findAllByClientId(Long clientId);

}
