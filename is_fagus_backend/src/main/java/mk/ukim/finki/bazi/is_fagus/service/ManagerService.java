package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Menadzeri;

public interface ManagerService {
    /**
     * @param id
     * @return Employee of type Menadzeri by given id
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.ManagerNotFoundException
     */
    Menadzeri findById(Long id);
}
