package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Data;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.BestClientViewId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Data
@Entity
@Subselect("select * from public.najdobri_klienti")
@Immutable
public class BestClientsView {

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name="clientId",column = @Column(name="id_klient")),
            @AttributeOverride(name="name", column=@Column(name="korisnicko_ime", length=100) ),
            @AttributeOverride(name="surname", column=@Column(name="prezime", length=100) ),
            @AttributeOverride(name="value", column=@Column(name="vkupna_cena") ) } )
    private BestClientViewId id;

}
