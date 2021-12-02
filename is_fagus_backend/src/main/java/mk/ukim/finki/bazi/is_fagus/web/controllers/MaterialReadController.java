package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.views.MaterialView;
import mk.ukim.finki.bazi.is_fagus.service.MaterialService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/material")
public class MaterialReadController {

    private final MaterialService materialService;

    public MaterialReadController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<MaterialView> findAll(){
        return this.materialService.findAll();
    }
}
