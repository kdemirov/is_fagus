package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.FurniturePartsViewId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Subselect("select * from public.furnite_parts_view")
@Immutable
@Data
public class FurniturePartsView {

    @EmbeddedId
    private FurniturePartsViewId furniturePartsViewId;

    @Column(name="vid_na_del")
    private String partType;

    @Column(name="cena")
    private Double price;
}
