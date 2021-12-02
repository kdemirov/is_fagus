package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.Materijali;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.MaterialNotFoundException;
import mk.ukim.finki.bazi.is_fagus.model.views.MaterialView;
import mk.ukim.finki.bazi.is_fagus.repository.MaterialRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.MaterialViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {


    private final MaterialRepository materialRepository;
    private final MaterialViewRepository materialViewRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository, MaterialViewRepository materialViewRepository) {
        this.materialRepository = materialRepository;
        this.materialViewRepository = materialViewRepository;
    }


    @Override
    public Optional<Materijali> addMaterial(String name, Double size, Integer quantity) {
        return Optional.of(this.materialRepository.save(
                new Materijali(size, name, quantity)
        ));
    }

    @Override
    public Optional<Materijali> editMaterial(Long id, Integer quantity) {
        Materijali materijali = this.findById(id);
        materijali.setDostapenBroj(quantity);
        return Optional.of(this.materialRepository.save(materijali));
    }

    @Override
    public Materijali findById(Long id) {
        return this.materialRepository.findById(id).orElseThrow(
                () -> new MaterialNotFoundException(id)
        );
    }

    @Override
    public List<MaterialView> findAll() {
        return this.materialViewRepository.findAll();
    }
}
