package mk.ukim.finki.bazi.is_fagus.model.views;

import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.FurniturePartsViewId;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Subselect("select * from public.order_extra_parts")
public class OrderExtraPartsView {
    @EmbeddedId
    private FurniturePartsViewId orderExtraPartsId;

    @Column(name="vid_na_del")
    private String partType;

    @Column(name="kolicina")
    private Integer quantity;

}
