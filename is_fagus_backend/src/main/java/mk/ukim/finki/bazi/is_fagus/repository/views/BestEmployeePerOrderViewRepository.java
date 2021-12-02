package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.BestEmployeesPerOrder;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.BestEmployeePerOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestEmployeePerOrderViewRepository extends JpaRepository<BestEmployeesPerOrder, BestEmployeePerOrderId> {
}
