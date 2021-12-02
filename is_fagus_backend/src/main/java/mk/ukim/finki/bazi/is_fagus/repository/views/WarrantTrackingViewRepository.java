package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.WarrantTrackingView;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.WarrantTrackingViewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import java.util.List;

public interface WarrantTrackingViewRepository extends JpaRepository<WarrantTrackingView, WarrantTrackingViewId> {
    List<WarrantTrackingView> findAllById_WarrantId(Long warrantId);
}
