package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.chief_parts_view")
@Immutable
@Getter
public class ChiefPartsView {

    @Column(name="id_mebel")
    private Long furnitureId;
    @Id
    @Column(name="id_del")
    private Long partId;

    @Column(name="naziv")
    private String name;
    @Column(name="vid_na_del")
    private String type;
}
