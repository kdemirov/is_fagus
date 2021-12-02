package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.EvidencijaNaNaracki;
import mk.ukim.finki.bazi.is_fagus.model.dto.RecordDto;
import mk.ukim.finki.bazi.is_fagus.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/record")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<EvidencijaNaNaracki> createRecord(@RequestBody RecordDto recordDto){
        return this.recordService.createRecord(recordDto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
