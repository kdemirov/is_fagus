package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.chiefs_machine_view")
@Immutable
@Getter
public class ChiefMachineView {

    @Id
    @Column(name="id_mashina")
    private Long machineId;

    @Column(name="naziv")
    private String machineName;

}
