package mk.ukim.finki.bazi.is_fagus.model.views.compositeIds;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class ShoppingCartViewId implements Serializable {

    @Column(name="id_kosnicka")
    private Long shoppingCartId;

    @Column(name="id_mebel")
    private Long furnitureId;
}
