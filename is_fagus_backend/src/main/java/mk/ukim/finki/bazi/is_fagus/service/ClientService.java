package mk.ukim.finki.bazi.is_fagus.service;


import mk.ukim.finki.bazi.is_fagus.model.Klienti;

import java.util.Optional;

public interface ClientService {

    /**
     * @param clientId
     * @return Klienti
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.UserNotFoundException
     */
    Klienti findById(Long clientId);
}
