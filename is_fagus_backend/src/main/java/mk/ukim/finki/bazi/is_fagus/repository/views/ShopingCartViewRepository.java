package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.ShoppingCartView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopingCartViewRepository extends JpaRepository<ShoppingCartView,Long> {

    List<ShoppingCartView> findAllById_ShoppingCartId(Long shoppingCartId);
}
