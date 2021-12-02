package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import mk.ukim.finki.bazi.is_fagus.model.VraboteniSeKorisnici;

public interface EmployeeUsersService {

    /**
     * @param userId
     * @return VraboteniSeKorisnici
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.UserNotFoundException
     */
    VraboteniSeKorisnici findByUserId(Long userId);
}
