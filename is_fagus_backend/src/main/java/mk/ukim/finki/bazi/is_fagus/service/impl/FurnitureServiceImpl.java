package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.views.FurniturePartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.FurnitureView;
import mk.ukim.finki.bazi.is_fagus.model.Mebel;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.FurnutureNotFoundException;
import mk.ukim.finki.bazi.is_fagus.repository.FurnitureJpaRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.FurniturePartViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.FurnitureViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureJpaRepository furnitureJpaRepository;
    private final FurnitureViewRepository furnitureViewRepository;
    private final FurniturePartViewRepository furniturePartViewRepository;
    public FurnitureServiceImpl(FurnitureJpaRepository furnitureJpaRepository,
                                FurnitureViewRepository furnitureViewRepository,
                                FurniturePartViewRepository furniturePartViewRepository) {
        this.furnitureJpaRepository = furnitureJpaRepository;
        this.furnitureViewRepository = furnitureViewRepository;
        this.furniturePartViewRepository = furniturePartViewRepository;

    }

    @Override
    public List<FurnitureView> findAll() {
        return this.furnitureViewRepository.findAll();
    }

    @Override
    public Mebel findById(Long id) {
        return this.furnitureJpaRepository.findById(id).orElseThrow(()->new FurnutureNotFoundException(id));
    }

    @Override
    public List<FurniturePartsView> findFurnitureParts(Long orderId) {
       return this.furniturePartViewRepository.findAllByFurniturePartsViewId_OrderId(orderId);
    }

    @Override
    public List<Mebel> findAllByIds(List<Long> furnituresId) {
        return this.furnitureJpaRepository.findAllById(furnituresId);
    }
}
