package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import javax.persistence.*;

/**
 * Nalozi generated by hbm2java
 */
@Entity
@Table(name = "nalozi")
@Getter
@Setter
public class Nalozi {

    @Id
    @Column(name = "id_nalog", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNalog;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vraboten", nullable = false)
    private Menadzeri menadzeri;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vraboten", nullable = false, insertable = false, updatable = false)
    private Vraboteni vraboteni;

    @Temporal(TemporalType.DATE)
    @Column(name = "krajna_data", length = 13)
    private Date krajnaData;
    @Temporal(TemporalType.DATE)
    @Column(name = "pocetna_data", nullable = false, length = 13)
    private Date pocetnaData;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "nalozi")
    private NaloziKreiraNaracka naloziKreiraNaracka;

    public Nalozi() {
    }


    public Nalozi(Menadzeri menadzeri, Vraboteni vraboteni, Date pocetnaData) {
        this.menadzeri = menadzeri;
        this.vraboteni = vraboteni;
        this.pocetnaData = pocetnaData;
    }

    public Nalozi(Menadzeri menadzeri,
                  Vraboteni vraboteni,
                  Date krajnaData, Date pocetnaData,
                  NaloziKreiraNaracka naloziKreiraNaracka) {
        this.menadzeri = menadzeri;
        this.vraboteni = vraboteni;
        this.krajnaData = krajnaData;
        this.pocetnaData = pocetnaData;
        this.naloziKreiraNaracka = naloziKreiraNaracka;
    }


}

