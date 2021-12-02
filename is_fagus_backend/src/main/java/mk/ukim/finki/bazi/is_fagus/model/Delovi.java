package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Delovi generated by hbm2java
 */
@Entity
@Table(name = "delovi")
@Getter
@Setter
public class Delovi  {


    @Id
    @Column(name = "id_del", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDel;

    @Column(name = "vid_na_del", nullable = false, length = 100)
    private String vidNaDel;
    @Column(name = "cena", nullable = false, precision = 17, scale = 17)
    private Double cena;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "delovi_izraboteni_od_mashina", joinColumns = {
            @JoinColumn(name = "id_del", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_mashina", nullable = false, updatable = false)})
    private Set<Mashini> mashinis = new HashSet<Mashini>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delovi")
    private Set<MebelSeSostoiOdDelovi> mebelSeSostoiOdDelovis = new HashSet<MebelSeSostoiOdDelovi>(0);
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delovi")
    private DeloviIzraboteniOdMaterijal deloviIzraboteniOdMaterijal;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delovi")
    private Set<DopolniteliDeloviZaNaracka> dopolniteliDeloviZaNarackas = new HashSet<DopolniteliDeloviZaNaracka>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delovi")
    private Set<EvidencijaNarackiIzraboteniDelovi> evidencijaNarackiIzraboteniDelovis = new HashSet<EvidencijaNarackiIzraboteniDelovi>(0);

    public Delovi() {
    }


    public Delovi(String vidNaDel, Double cena) {
        this.vidNaDel = vidNaDel;
        this.cena = cena;
    }

    public Delovi(String vidNaDel, Double cena, Set<Mashini> mashinis, Set<MebelSeSostoiOdDelovi> mebelSeSostoiOdDelovis, DeloviIzraboteniOdMaterijal deloviIzraboteniOdMaterijal, Set<DopolniteliDeloviZaNaracka> dopolniteliDeloviZaNarackas, Set<EvidencijaNarackiIzraboteniDelovi> evidencijaNarackiIzraboteniDelovis) {
        this.vidNaDel = vidNaDel;
        this.cena = cena;
        this.mashinis = mashinis;
        this.mebelSeSostoiOdDelovis = mebelSeSostoiOdDelovis;
        this.deloviIzraboteniOdMaterijal = deloviIzraboteniOdMaterijal;
        this.dopolniteliDeloviZaNarackas = dopolniteliDeloviZaNarackas;
        this.evidencijaNarackiIzraboteniDelovis = evidencijaNarackiIzraboteniDelovis;
    }


}


