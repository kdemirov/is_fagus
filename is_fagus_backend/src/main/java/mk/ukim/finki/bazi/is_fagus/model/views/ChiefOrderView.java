package mk.ukim.finki.bazi.is_fagus.model.views;

import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.chief_order_view")
public class ChiefOrderView {

    @Id
    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="id_mebel")
    private Long furnitureId;

    @Column(name="tip")
    private String type;

    @Column(name="kolicina")
    private Integer quantity;
}
