package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefMachineView;

import java.util.List;

public interface MachineService {

    /**
     * @return List of Machines wiht in View check ChiefMachineView
     */
    List<ChiefMachineView> findAllMachineView();
}
