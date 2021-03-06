package mk.ukim.finki.bazi.is_fagus.model;

// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * VraboteniVoProizvodstvoRabotiNaMashina generated by hbm2java
 */
@Entity
@Table(name="vraboteni_vo_proizvodstvo_raboti_na_mashina"
)
public class VraboteniVoProizvodstvoRabotiNaMashina  implements java.io.Serializable {


     private Long idVraboten;
     private Mashini mashini;
     private VraboteniVoProizvodstvo vraboteniVoProizvodstvo;

    public VraboteniVoProizvodstvoRabotiNaMashina() {
    }

	
    public VraboteniVoProizvodstvoRabotiNaMashina(VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
        this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }
    public VraboteniVoProizvodstvoRabotiNaMashina(Mashini mashini, VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
       this.mashini = mashini;
       this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="vraboteniVoProizvodstvo"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id_vraboten", unique=true, nullable=false)
    public Long getIdVraboten() {
        return this.idVraboten;
    }
    
    public void setIdVraboten(Long idVraboten) {
        this.idVraboten = idVraboten;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_mashina")
    public Mashini getMashini() {
        return this.mashini;
    }
    
    public void setMashini(Mashini mashini) {
        this.mashini = mashini;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public VraboteniVoProizvodstvo getVraboteniVoProizvodstvo() {
        return this.vraboteniVoProizvodstvo;
    }
    
    public void setVraboteniVoProizvodstvo(VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
        this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }




}


