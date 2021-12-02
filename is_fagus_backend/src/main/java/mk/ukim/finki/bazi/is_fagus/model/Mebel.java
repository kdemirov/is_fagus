package mk.ukim.finki.bazi.is_fagus.model;
// Generated Sep 26, 2021, 3:23:30 AM by Hibernate Tools 4.3.5.Final


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Mebel generated by hbm2java
 */
@Entity
@Table(name = "mebel")
@Getter
@Setter
public class Mebel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mebel")
    private Long idMebel;
    @Column(name = "tip", nullable = false, length = 100)
    private String tip;
    @Column(name = "naziv", nullable = false, length = 50)
    private String naziv;
    @Column(name = "cena", nullable = false, precision = 17, scale = 17)
    private Double cena;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mebel")
    private Set<MebelSeSostoiOdDelovi> mebelSeSostoiOdDelovis=new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mebel")
    private Set<NarackaSeSostoiOdMebel> narackaSeSostoiOdMebels =  new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mebel")
    private Set<EvidencijaSeOdnesuvaNaMebel> evidencijaSeOdnesuvaNaMebels = new HashSet<>(0);


    public Mebel() {
    }


    public Mebel(String naziv, String tip, Double cena) {
        this.tip = tip;
        this.naziv = naziv;
        this.cena = cena;
    }


}

