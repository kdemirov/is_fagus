package mk.ukim.finki.bazi.is_fagus.model.views.compositeIds;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FurniturePartsViewId implements Serializable {

    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="id_del")
    private Long partId;
}
