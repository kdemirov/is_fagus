package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefEmployeeView;
import mk.ukim.finki.bazi.is_fagus.repository.views.ChiefEmployeeViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ChiefEmployeeViewRepository chiefEmployeeViewRepository;

    public EmployeeServiceImpl(ChiefEmployeeViewRepository chiefEmployeeViewRepository) {
        this.chiefEmployeeViewRepository = chiefEmployeeViewRepository;
    }

    @Override
    public List<ChiefEmployeeView> findAll() {
        return this.chiefEmployeeViewRepository.findAll();
    }
}
