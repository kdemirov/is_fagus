package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Subselect("select * from public.furniture_view")
@Immutable
public class FurnitureView {

    @Id
    @Column(name="id_mebel")
    private Long idMebel;

    @Column(name="naziv")
    private String naziv;

    @Column(name="tip")
    private String tip;

    @Column(name="cena")
    private Double cena;
}
