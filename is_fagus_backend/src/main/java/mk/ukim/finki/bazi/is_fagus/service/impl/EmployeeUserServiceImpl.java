package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.Vraboteni;
import mk.ukim.finki.bazi.is_fagus.model.VraboteniSeKorisnici;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.UserNotFoundException;
import mk.ukim.finki.bazi.is_fagus.repository.EmployeeUsersRepository;
import mk.ukim.finki.bazi.is_fagus.service.EmployeeUsersService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUserServiceImpl implements EmployeeUsersService {

    private final EmployeeUsersRepository employeeUsersRepository;

    public EmployeeUserServiceImpl(EmployeeUsersRepository employeeUsersRepository) {
        this.employeeUsersRepository = employeeUsersRepository;
    }

    @Override
    public VraboteniSeKorisnici findByUserId(Long userId) {
        return this.employeeUsersRepository.findByIdKorisnik(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

}
