package mk.ukim.finki.bazi.is_fagus.model.views.compositeIds;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BestClientViewId implements Serializable {


    @Column(name="id_klient")
    private Long clientId;

    @Column(name="korisnicko_ime")
    private String name;

    @Column(name="prezime")
    private String surname;

    @Column(name="vkupna_cena")
    private Double value;

}
