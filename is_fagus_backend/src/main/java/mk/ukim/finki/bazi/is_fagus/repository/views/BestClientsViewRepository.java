package mk.ukim.finki.bazi.is_fagus.repository.views;

import mk.ukim.finki.bazi.is_fagus.model.views.BestClientsView;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.BestClientViewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestClientsViewRepository extends JpaRepository<BestClientsView, BestClientViewId> {
}
