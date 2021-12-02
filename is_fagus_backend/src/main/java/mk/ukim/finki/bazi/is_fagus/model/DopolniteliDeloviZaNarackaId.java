package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DopolniteliDeloviZaNarackaId generated by hbm2java
 */
@Embeddable
@Getter
@Setter
public class DopolniteliDeloviZaNarackaId implements java.io.Serializable {

    @Column(name = "id_naracka", nullable = false)
    private Long idNaracka;
    @Column(name = "id_del", nullable = false)
    private Long idDel;

    public DopolniteliDeloviZaNarackaId() {
    }

    public DopolniteliDeloviZaNarackaId(Long idNaracka, Long idDel) {
        this.idNaracka = idNaracka;
        this.idDel = idDel;
    }

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof DopolniteliDeloviZaNarackaId)) return false;
        DopolniteliDeloviZaNarackaId castOther = (DopolniteliDeloviZaNarackaId) other;

        return (this.getIdNaracka() == castOther.getIdNaracka())
                && (this.getIdDel() == castOther.getIdDel());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getIdNaracka().intValue();
        result = 37 * result + this.getIdDel().intValue();
        return result;
    }


}


