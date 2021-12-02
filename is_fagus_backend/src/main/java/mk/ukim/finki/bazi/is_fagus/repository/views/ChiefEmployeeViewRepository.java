package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefEmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiefEmployeeViewRepository extends JpaRepository<ChiefEmployeeView,Long> {

    List<ChiefEmployeeView> findAllByMachineId(Long machineId);
}
