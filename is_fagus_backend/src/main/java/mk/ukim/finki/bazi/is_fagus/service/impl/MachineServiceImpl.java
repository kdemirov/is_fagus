package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefMachineView;
import mk.ukim.finki.bazi.is_fagus.repository.views.ChiefMachineViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.MachineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    private final ChiefMachineViewRepository chiefMachineViewRepository;

    public MachineServiceImpl(ChiefMachineViewRepository chiefMachineViewRepository) {
        this.chiefMachineViewRepository = chiefMachineViewRepository;
    }

    @Override
    public List<ChiefMachineView> findAllMachineView() {
        return this.chiefMachineViewRepository.findAll();
    }
}
