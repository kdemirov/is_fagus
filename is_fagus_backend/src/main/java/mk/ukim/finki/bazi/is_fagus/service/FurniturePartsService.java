package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Delovi;
import mk.ukim.finki.bazi.is_fagus.model.views.ChiefPartsView;

import java.util.List;
import java.util.Optional;

public interface FurniturePartsService {


    /**
     * @return List of all parts within view
     */
    List<ChiefPartsView> findAllByFurnitureId();

    /**
     * @param id
     * @return One single part
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException
     */
    Delovi findById(Long id);
}
