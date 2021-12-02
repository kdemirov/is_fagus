package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.chief_employee_view")
@Immutable
@Getter
public class ChiefEmployeeView {
    @Id
    @Column(name="id_mashina")
    private Long machineId;

    @Column(name="id_vraboten")
    private Long employeeId;

    @Column(name="ime")
    private String name;

    @Column(name="prezime")
    private String surname;
}
