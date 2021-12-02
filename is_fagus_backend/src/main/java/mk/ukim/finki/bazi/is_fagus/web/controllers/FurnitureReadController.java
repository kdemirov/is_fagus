package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.MebelSeSostoiOdDelovi;
import mk.ukim.finki.bazi.is_fagus.model.views.FurniturePartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.FurnitureView;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/furniture")
public class FurnitureReadController {

    private final FurnitureService furnitureService;

    public FurnitureReadController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public List<FurnitureView> findAll(){
        List<FurnitureView> list= this.furnitureService.findAll();
        return list;
    }
    @GetMapping("/parts/{id}")
    public List<FurniturePartsView> findPartsForFurnitureId(@PathVariable Long id){
        return this.furnitureService.findFurnitureParts(id);
    }

}
