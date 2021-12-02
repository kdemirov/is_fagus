package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.BestEmployeePerOrderId;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Data
@Entity
@Subselect("select * from public.najdobri_vraboteni_po_naracka")
public class BestEmployeesPerOrder {

    @EmbeddedId

    @AttributeOverrides( {
            @AttributeOverride(name="name", column=@Column(name="ime", length=100) ),
            @AttributeOverride(name="surname", column=@Column(name="prezime", length=100) ),
            @AttributeOverride(name="value", column=@Column(name="max") ) } )
    private BestEmployeePerOrderId bestEmployeePerOrderId;
    @Column(name="naslov")
    private String title;



}
