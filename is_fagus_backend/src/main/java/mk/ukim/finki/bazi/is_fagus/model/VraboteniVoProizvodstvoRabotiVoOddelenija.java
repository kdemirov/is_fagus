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
 * VraboteniVoProizvodstvoRabotiVoOddelenija generated by hbm2java
 */
@Entity
@Table(name="vraboteni_vo_proizvodstvo_raboti_vo_oddelenija"
)
public class VraboteniVoProizvodstvoRabotiVoOddelenija  implements java.io.Serializable {


     private Long idVraboten;
     private Oddelenija oddelenija;
     private Vraboteni vraboteni;
     private VraboteniVoProizvodstvo vraboteniVoProizvodstvo;

    public VraboteniVoProizvodstvoRabotiVoOddelenija() {
    }

	
    public VraboteniVoProizvodstvoRabotiVoOddelenija(Vraboteni vraboteni, VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
        this.vraboteni = vraboteni;
        this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }
    public VraboteniVoProizvodstvoRabotiVoOddelenija(Oddelenija oddelenija, Vraboteni vraboteni, VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
       this.oddelenija = oddelenija;
       this.vraboteni = vraboteni;
       this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="vraboteni"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id_vraboten", unique=true, nullable=false)
    public Long getIdVraboten() {
        return this.idVraboten;
    }
    
    public void setIdVraboten(Long idVraboten) {
        this.idVraboten = idVraboten;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_oddelenie")
    public Oddelenija getOddelenija() {
        return this.oddelenija;
    }
    
    public void setOddelenija(Oddelenija oddelenija) {
        this.oddelenija = oddelenija;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Vraboteni getVraboteni() {
        return this.vraboteni;
    }
    
    public void setVraboteni(Vraboteni vraboteni) {
        this.vraboteni = vraboteni;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public VraboteniVoProizvodstvo getVraboteniVoProizvodstvo() {
        return this.vraboteniVoProizvodstvo;
    }
    
    public void setVraboteniVoProizvodstvo(VraboteniVoProizvodstvo vraboteniVoProizvodstvo) {
        this.vraboteniVoProizvodstvo = vraboteniVoProizvodstvo;
    }




}


