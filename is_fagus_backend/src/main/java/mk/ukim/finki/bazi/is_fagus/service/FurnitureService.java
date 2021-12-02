package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.MebelSeSostoiOdDelovi;
import mk.ukim.finki.bazi.is_fagus.model.views.FurniturePartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.FurnitureView;
import mk.ukim.finki.bazi.is_fagus.model.Mebel;

import java.util.List;
import java.util.Set;

public interface FurnitureService {


    /**
     * @return List of Mebel within view
     */
    List<FurnitureView> findAll();

    /**
     * @param id
     * @return Furniture by the given id
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurnutureNotFoundException
     */
    Mebel findById(Long id);

    /**
     * @param orderId
     * @return parts for furniture within Order given by orderId
     *
     */
    List<FurniturePartsView> findFurnitureParts(Long orderId);

    /**
     * @param furnituresId
     * @return List of Mebel for the given furnituresIds
     */
    List<Mebel> findAllByIds(List<Long> furnituresId);
}
