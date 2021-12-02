package mk.ukim.finki.bazi.is_fagus.model.views.compositeIds;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class WarrantTrackingViewId implements Serializable {

    @Column(name="id_nalog")
    private Long warrantId;

    @Column(name="ime")
    private String name;

    @Column(name="prezime")
    private String surname;

    @Column(name="kolicina")
    private String quantity;

    @Column(name="datum")
    private Date date;
}
