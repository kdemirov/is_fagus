package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.EvidencijaNaNaracki;
import mk.ukim.finki.bazi.is_fagus.model.dto.RecordDto;

import java.util.Optional;

public interface RecordService {

    /**
     * @param recordDto Data transfer object which contains all the information for creating EvidencijaNaNaracki
     * @return EvidencijaNaNaracki if the record is created successfully
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurnutureNotFoundException
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException
     */
    Optional<EvidencijaNaNaracki> createRecord(RecordDto recordDto);
}
