package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.Materijali;
import mk.ukim.finki.bazi.is_fagus.model.dto.EditMaterialDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.MaterialDto;
import mk.ukim.finki.bazi.is_fagus.service.MaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public Optional<Materijali> addMaterial(@RequestBody MaterialDto materialDto){
        return this.materialService.addMaterial(materialDto.getName(),materialDto.getSize(),materialDto.getQuantity());
    }
    @PutMapping("/{id}")
    public Optional<Materijali> editMaterial(@PathVariable Long id,
                                             @RequestBody EditMaterialDto materialDto){
        return  this.materialService.editMaterial(id,materialDto.getQuantity());
    }


}
