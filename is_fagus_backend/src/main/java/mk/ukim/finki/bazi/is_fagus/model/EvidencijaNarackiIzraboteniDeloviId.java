package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * EvidencijaNarackiIzraboteniDeloviId generated by hbm2java
 */
@Embeddable
@Getter
public class EvidencijaNarackiIzraboteniDeloviId implements Serializable {

    @Column(name="id_evidencija", nullable=false)
     private Long idEvidencija;
    @Column(name="id_del", nullable=false)
     private Long idDel;

    public EvidencijaNarackiIzraboteniDeloviId() {
    }

    public EvidencijaNarackiIzraboteniDeloviId(Long idEvidencija, Long idDel) {
        this.idEvidencija = idEvidencija;
        this.idDel = idDel;
    }
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EvidencijaNarackiIzraboteniDeloviId) ) return false;
		 EvidencijaNarackiIzraboteniDeloviId castOther = ( EvidencijaNarackiIzraboteniDeloviId ) other; 
         
		 return (this.getIdEvidencija()==castOther.getIdEvidencija())
 && (this.getIdDel()==castOther.getIdDel());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdEvidencija().intValue();
         result = 37 * result + this.getIdDel().intValue();
         return result;
   }   


}


