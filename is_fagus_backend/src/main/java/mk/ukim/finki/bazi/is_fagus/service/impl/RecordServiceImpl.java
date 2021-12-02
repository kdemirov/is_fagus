package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.*;
import mk.ukim.finki.bazi.is_fagus.model.dto.RecordDto;
import mk.ukim.finki.bazi.is_fagus.repository.RecordForFurnitureRepository;
import mk.ukim.finki.bazi.is_fagus.repository.RecordRepository;
import mk.ukim.finki.bazi.is_fagus.repository.RecordsForDonePartsRepository;
import mk.ukim.finki.bazi.is_fagus.service.FurniturePartsService;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;
import mk.ukim.finki.bazi.is_fagus.service.OrdersService;
import mk.ukim.finki.bazi.is_fagus.service.RecordService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;
    private final OrdersService ordersService;
    private final FurnitureService furnitureService;
    private final FurniturePartsService furniturePartsService;
    private final RecordsForDonePartsRepository recordsForDonePartsRepository;
    private final RecordForFurnitureRepository recordForFurnitureRepository;

    public RecordServiceImpl(RecordRepository recordRepository,
                             OrdersService ordersService,
                             FurnitureService furnitureService,
                             FurniturePartsService furniturePartsService,
                             RecordsForDonePartsRepository recordsForDonePartsRepository,
                             RecordForFurnitureRepository recordForFurnitureRepository) {
        this.recordRepository = recordRepository;
        this.ordersService = ordersService;
        this.furnitureService = furnitureService;
        this.furniturePartsService = furniturePartsService;
        this.recordsForDonePartsRepository = recordsForDonePartsRepository;
        this.recordForFurnitureRepository = recordForFurnitureRepository;
    }

    @Override
    public Optional<EvidencijaNaNaracki> createRecord(RecordDto recordDto) {
        Naracka naracka = this.ordersService.findById(recordDto.getOrderId());
        Mebel mebel = this.furnitureService.findById(recordDto.getFurnitureId());
        Delovi del = this.furniturePartsService.findById(recordDto.getPartId());
        EvidencijaNaNaracki evidencijaNaNaracki = this.recordRepository
                .save(new EvidencijaNaNaracki(naracka, Date.from(Instant.now())));
        EvidencijaNarackiIzraboteniDelovi izraboteniDelovi = this.recordsForDonePartsRepository
                .save(new EvidencijaNarackiIzraboteniDelovi(
                        new EvidencijaNarackiIzraboteniDeloviId(evidencijaNaNaracki.getIdEvidencija(),
                                del.getIdDel()),
                        del,
                        evidencijaNaNaracki,
                        recordDto.getQuantity()

                ));
        return Optional.of(evidencijaNaNaracki);

    }
}
