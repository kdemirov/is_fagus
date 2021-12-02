package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Materijali;
import mk.ukim.finki.bazi.is_fagus.model.views.MaterialView;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    /**
     * @param name Name of the material
     * @param size Size of the Material
     * @param quantity Quantity of the materijal
     * @return Oprional of Materijali if the material is added successfully
     */
    Optional<Materijali> addMaterial(String name,Double size,Integer quantity);

    /**
     * @param id Given id for updating material
     * @param quantity new quanity for the material with the given id
     * @return Optional of Material if the material is successfully updated
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.MaterialNotFoundException
     */
    Optional<Materijali> editMaterial(Long id,Integer quantity);

    /**
     * @param id Find Materijali by given id
     * @return Materijali
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.MaterialNotFoundException
     */
    Materijali findById(Long id);

    /**
     * @return List of Materijali within view check MaterialView
     */
    List<MaterialView> findAll();
}
