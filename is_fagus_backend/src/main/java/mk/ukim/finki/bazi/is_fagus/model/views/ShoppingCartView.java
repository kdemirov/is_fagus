package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.ShoppingCartViewId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.shopping_cart_view")
@Immutable
@Getter
public class ShoppingCartView {

    @Id
    private ShoppingCartViewId id;


    @Column(name="naziv")
    private String furnitureTitle;

    @Column(name="tip")
    private String furnitureType;

    @Column(name="cena")
    private Double furniturePrice;
}
