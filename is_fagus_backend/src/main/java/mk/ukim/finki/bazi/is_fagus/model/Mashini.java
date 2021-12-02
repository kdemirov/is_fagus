package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Mashini generated by hbm2java
 */
@Entity
@Table(name="mashini"
)
public class Mashini  implements java.io.Serializable {


     private int idMashina;
     private String naziv;
     private Set<VraboteniVoProizvodstvoRabotiNaMashina> vraboteniVoProizvodstvoRabotiNaMashinas = new HashSet<VraboteniVoProizvodstvoRabotiNaMashina>(0);
     private Set<Delovi> delovis = new HashSet<Delovi>(0);
     private Set<ImaNapravenoServis> imaNapravenoServises = new HashSet<ImaNapravenoServis>(0);
     private MashinaPripagaOddelenie mashinaPripagaOddelenie;

    public Mashini() {
    }

	
    public Mashini(int idMashina, String naziv) {
        this.idMashina = idMashina;
        this.naziv = naziv;
    }
    public Mashini(int idMashina, String naziv, Set<VraboteniVoProizvodstvoRabotiNaMashina> vraboteniVoProizvodstvoRabotiNaMashinas,  Set<Delovi> delovis, Set<ImaNapravenoServis> imaNapravenoServises, MashinaPripagaOddelenie mashinaPripagaOddelenie) {
       this.idMashina = idMashina;
       this.naziv = naziv;
       this.vraboteniVoProizvodstvoRabotiNaMashinas = vraboteniVoProizvodstvoRabotiNaMashinas;
       this.delovis = delovis;
       this.imaNapravenoServises = imaNapravenoServises;
       this.mashinaPripagaOddelenie = mashinaPripagaOddelenie;
    }
   
     @Id 

    
    @Column(name="id_mashina", unique=true, nullable=false)
    public int getIdMashina() {
        return this.idMashina;
    }
    
    public void setIdMashina(int idMashina) {
        this.idMashina = idMashina;
    }

    
    @Column(name="naziv", nullable=false, length=50)
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mashini")
    public Set<VraboteniVoProizvodstvoRabotiNaMashina> getVraboteniVoProizvodstvoRabotiNaMashinas() {
        return this.vraboteniVoProizvodstvoRabotiNaMashinas;
    }
    
    public void setVraboteniVoProizvodstvoRabotiNaMashinas(Set<VraboteniVoProizvodstvoRabotiNaMashina> vraboteniVoProizvodstvoRabotiNaMashinas) {
        this.vraboteniVoProizvodstvoRabotiNaMashinas = vraboteniVoProizvodstvoRabotiNaMashinas;
    }



@ManyToMany(fetch=FetchType.LAZY, mappedBy="mashinis")
    public Set<Delovi> getDelovis() {
        return this.delovis;
    }
    
    public void setDelovis(Set<Delovi> delovis) {
        this.delovis = delovis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mashini")
    public Set<ImaNapravenoServis> getImaNapravenoServises() {
        return this.imaNapravenoServises;
    }
    
    public void setImaNapravenoServises(Set<ImaNapravenoServis> imaNapravenoServises) {
        this.imaNapravenoServises = imaNapravenoServises;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="mashini")
    public MashinaPripagaOddelenie getMashinaPripagaOddelenie() {
        return this.mashinaPripagaOddelenie;
    }
    
    public void setMashinaPripagaOddelenie(MashinaPripagaOddelenie mashinaPripagaOddelenie) {
        this.mashinaPripagaOddelenie = mashinaPripagaOddelenie;
    }




}


