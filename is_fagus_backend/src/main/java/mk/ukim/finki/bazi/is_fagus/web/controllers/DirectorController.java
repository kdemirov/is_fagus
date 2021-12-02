package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.views.BestClientsView;
import mk.ukim.finki.bazi.is_fagus.model.views.BestEmployeesPerOrder;
import mk.ukim.finki.bazi.is_fagus.repository.views.BestClientsViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.BestEmployeePerOrderViewRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/director")
public class DirectorController {

    private final BestClientsViewRepository bestClientsViewRepository;
    private final BestEmployeePerOrderViewRepository bestEmployeePerOrderViewRepository;

    public DirectorController(BestClientsViewRepository bestClientsViewRepository, BestEmployeePerOrderViewRepository bestEmployeePerOrderViewRepository) {
        this.bestClientsViewRepository = bestClientsViewRepository;
        this.bestEmployeePerOrderViewRepository = bestEmployeePerOrderViewRepository;
    }

    @GetMapping("/clients")
    public List<BestClientsView> findAll(){
        return this.bestClientsViewRepository.findAll();
    }

    @GetMapping("/employees")
    public List<BestEmployeesPerOrder> findBestEmployeesPerOrder(){
        return this.bestEmployeePerOrderViewRepository.findAll();
    }
}
