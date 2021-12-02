package mk.ukim.finki.bazi.is_fagus.model.views;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Subselect("select * from public.manager_warrant_view")
@Immutable
@Getter
public class ManagersWarrantsView {

    @Id
    @Column(name="id_nalog")
    private Long warrantId;

    @Column(name="pocetna_data")
    private Date startDate;

    @Column(name="krajna_data")
    private Date endDate;
}
