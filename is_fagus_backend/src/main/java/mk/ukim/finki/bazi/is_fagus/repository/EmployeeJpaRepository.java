package mk.ukim.finki.bazi.is_fagus.repository;

import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Vraboteni,Long> {
}
