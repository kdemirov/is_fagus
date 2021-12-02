package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.percent_per_order")
@Immutable
@Data
public class OrderPercentDoneView {
    @Id
    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="naslov")
    private String title;

    @Column(name="id_klient")
    private Long clientId;

    @Column(name="procent_po_naracka")
    private Double percent;


}
