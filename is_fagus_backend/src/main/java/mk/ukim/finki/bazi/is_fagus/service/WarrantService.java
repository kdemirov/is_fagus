package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Nalozi;
import mk.ukim.finki.bazi.is_fagus.model.views.ChiefsWarrantView;
import mk.ukim.finki.bazi.is_fagus.model.views.ManagersWarrantsView;
import mk.ukim.finki.bazi.is_fagus.model.views.WarrantTrackingView;

import java.util.List;
import java.util.Optional;

public interface WarrantService {
    /**
     * @param username Current loggedin user
     * @param orderId given orderId selected order in frontend
     * @return Optional of Nalozi if the object is successfully saved
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     */
    Optional<Nalozi> create(String username, Long orderId);

    /**
     * @param warrantId  selected warrantId in the frontend by the Manager
     * @return Optional of Nalozi if the command is executed successfully
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.WarrantNotFoundException
     */
    Optional<Nalozi> endWarrant(Long warrantId);

    /**
     * @return List of ManagerWarrantsView for an easy shown way in frontend
     */
    List<ManagersWarrantsView> fetchAll();

    /**
     * @param warrantId given warrantiD
     * @return Optional of ChiefWarrantView for entering information about the current Nalozi
     *
     */
    Optional<ChiefsWarrantView> findByWarrantId(Long warrantId);

    /**
     * @param id send from frontend
     * @return List of WarrantTrackingItem for an easy shown way in frontend
     */
    List<WarrantTrackingView> findById(Long id);

}
