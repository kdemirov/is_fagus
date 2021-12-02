package mk.ukim.finki.bazi.is_fagus.model;

import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.bazi.is_fagus.model.enumerations.ShoppingCardStatus;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="kosnicka")
public class ShoppingCart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_kosnicka")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_klient")
    private Klienti client;
    @JoinTable(name="kosnicka_se_sostoi_od_mebel",
    joinColumns = @JoinColumn(name = "id_kosnicka"),
    inverseJoinColumns = @JoinColumn(name="id_mebel"))
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Mebel> furnitures;

    @Column(name="datum_napravena")
    private Date dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private ShoppingCardStatus status;


    public ShoppingCart(){}

    public ShoppingCart(Klienti client){
        this.dateCreated=Date.from(Instant.now());
        this.client=client;
        this.status=ShoppingCardStatus.CREATED;
        this.furnitures=new ArrayList<>();
    }
}
