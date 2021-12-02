package mk.ukim.finki.bazi.is_fagus.model.views;

import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.ShoppingCartViewId;
import mk.ukim.finki.bazi.is_fagus.model.views.compositeIds.WarrantTrackingViewId;
import org.hibernate.annotations.Subselect;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Subselect("select * from public.warrant_record_tracing")
public class WarrantTrackingView {
    @EmbeddedId
    private WarrantTrackingViewId id;
}
