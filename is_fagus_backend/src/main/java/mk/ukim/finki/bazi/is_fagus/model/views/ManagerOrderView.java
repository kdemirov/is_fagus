package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Immutable
@Data
@Subselect("select * from public.manager_orders_view")
public class ManagerOrderView {

    @Id
    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="datum_napravena")
    private Date dateOrdered;

    @Column(name="naslov")
    private String title;

    @Column(name="opis")
    private String description;


}
