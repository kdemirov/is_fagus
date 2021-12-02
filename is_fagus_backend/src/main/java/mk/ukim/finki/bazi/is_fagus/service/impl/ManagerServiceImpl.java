package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.Menadzeri;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.ManagerNotFoundException;
import mk.ukim.finki.bazi.is_fagus.repository.ManagersRepository;
import mk.ukim.finki.bazi.is_fagus.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagersRepository managersRepository;

    public ManagerServiceImpl(ManagersRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    @Override
    public Menadzeri findById(Long id) {
        return this.managersRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException(id));
    }
}
