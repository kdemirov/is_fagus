package mk.ukim.finki.bazi.is_fagus.model.views.compositeIds;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BestEmployeePerOrderId implements Serializable {

    @Column(name="id_naracka")
    private Long orderId;

    @Column(name="ime")
    private String name;

    @Column(name="prezime")
    private String surname;

    @Column(name="max")
    private Integer value;
}
