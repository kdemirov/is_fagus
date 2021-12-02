package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Subselect("select * from public.orders_view")
@Immutable
public class OrdersView {

    @Id
    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="naslov")
    private String title;

    @Column(name="opis")
    private String description;

    @Column(name="vkupna_cena")
    private Double price;

    @Column(name="id_klient")
    private Long clientId;

    @Column(name="datum_napravena")
    private Date startDate;

    @Column(name="datum_isporacana")
    private Date shippedDate;
}
