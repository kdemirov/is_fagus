package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.chief_warrant_view")
@Immutable
@Getter
public class ChiefsWarrantView {

    @Id
    @Column(name="id_nalog")
    private Long warrantId;


    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="naslov")
    private String orderTitle;

}
