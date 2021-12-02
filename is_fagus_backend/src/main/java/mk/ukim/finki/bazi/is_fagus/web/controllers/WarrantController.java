package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.Nalozi;
import mk.ukim.finki.bazi.is_fagus.model.dto.CreateWarrantDto;
import mk.ukim.finki.bazi.is_fagus.service.WarrantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/warrant")
public class WarrantController {

    private final WarrantService warrantService;

    public WarrantController(WarrantService warrantService) {
        this.warrantService = warrantService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Nalozi> create(@RequestBody CreateWarrantDto dto,
                                         @AuthenticationPrincipal String username){
        return this.warrantService.create(username,dto.getOrderId())
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/{warrantId}")
    public ResponseEntity<Nalozi> setEndWarrant(@PathVariable Long warrantId){
        return this.warrantService.endWarrant(warrantId)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
