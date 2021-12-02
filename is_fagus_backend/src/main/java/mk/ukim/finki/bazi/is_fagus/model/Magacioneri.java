package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Magacioneri generated by hbm2java
 */
@Entity
@Table(name="magacioneri"
)
public class Magacioneri  implements java.io.Serializable {


     private Long idVraboten;
     private Vraboteni vraboteni;

    public Magacioneri() {
    }

    public Magacioneri(Vraboteni vraboteni) {
       this.vraboteni = vraboteni;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="vraboteni"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id_vraboten", unique=true, nullable=false)
    public Long getIdVraboten() {
        return this.idVraboten;
    }
    
    public void setIdVraboten(Long idVraboten) {
        this.idVraboten = idVraboten;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Vraboteni getVraboteni() {
        return this.vraboteni;
    }
    
    public void setVraboteni(Vraboteni vraboteni) {
        this.vraboteni = vraboteni;
    }




}


