package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * EvidencijaNaNaracki generated by hbm2java
 */
@Entity
@Table(name = "evidencija_na_naracki")
@Getter
@Setter
public class EvidencijaNaNaracki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencija", unique = true, nullable = false)
    private Long idEvidencija;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_naracka", nullable = false)
    private Naracka naracka;

    @Temporal(TemporalType.DATE)
    @Column(name = "datum", nullable = false, length = 13)
    private Date datum;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evidencijaNaNaracki")
    private Set<EvidencijaNarackiIzraboteniDelovi> evidencijaNarackiIzraboteniDelovis;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "evidencijaNaNaracki")
    private EvidencijaSeOdnesuvaNaMebel evidencijaSeOdnesuvaNaMebel;


    public EvidencijaNaNaracki() {
    }


    public EvidencijaNaNaracki( Naracka naracka, Date datum) {
        this.naracka = naracka;
        this.datum = datum;
    }
}


