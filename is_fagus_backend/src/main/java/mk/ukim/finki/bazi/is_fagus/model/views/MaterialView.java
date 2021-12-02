package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.material_view")
@Immutable
@Data
public class MaterialView {

    @Id
    @Column(name = "id_materijal")
    private Long materialId;

    @Column(name = "velicina")
    private Double size;

    @Column(name = "naziv")
    private String name;

    @Column(name = "dostapen_broj")
    private Integer quantity;
}
