package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.views.ChiefEmployeeView;

import java.util.List;

public interface EmployeeService {

    /**
     * @return list of ChiefEmployeeView
     */
    List<ChiefEmployeeView> findAll();
}
