package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.Delovi;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException;
import mk.ukim.finki.bazi.is_fagus.model.views.ChiefPartsView;
import mk.ukim.finki.bazi.is_fagus.repository.FurniturePartsRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.ChiefPartViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.FurniturePartsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurniturePartsServiceImpl implements FurniturePartsService {

    private final ChiefPartViewRepository chiefPartViewRepository;
    private final FurniturePartsRepository furniturePartsRepository;

    public FurniturePartsServiceImpl(ChiefPartViewRepository chiefPartViewRepository,
                                     FurniturePartsRepository furniturePartsRepository) {
        this.chiefPartViewRepository = chiefPartViewRepository;
        this.furniturePartsRepository = furniturePartsRepository;
    }


    @Override
    public List<ChiefPartsView> findAllByFurnitureId() {
        return this.chiefPartViewRepository.findAll();
    }

    @Override
    public Delovi findById(Long id) {
        return this.furniturePartsRepository.findById(id)
                .orElseThrow(() -> new FurniturePartDoesNotExistException(id));
    }
}
