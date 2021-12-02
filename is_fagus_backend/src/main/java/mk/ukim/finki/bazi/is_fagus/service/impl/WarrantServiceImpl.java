package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.*;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.WarrantNotFoundException;
import mk.ukim.finki.bazi.is_fagus.model.views.ChiefsWarrantView;
import mk.ukim.finki.bazi.is_fagus.model.views.ManagersWarrantsView;
import mk.ukim.finki.bazi.is_fagus.model.views.WarrantTrackingView;
import mk.ukim.finki.bazi.is_fagus.repository.OrderCreateWarrantsRepository;
import mk.ukim.finki.bazi.is_fagus.repository.WarrantRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.ChiefWarrantViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.ManagersWarrantsViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.WarrantTrackingViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class WarrantServiceImpl implements WarrantService {

    private final OrdersService ordersService;
    private final WarrantRepository warrantRepository;
    private final EmployeeUsersService employeeUsersService;
    private final UserService userService;
    private final ManagerService managerService;
    private final OrderCreateWarrantsRepository orderCreateWarrantsRepository;
    private final ManagersWarrantsViewRepository managersWarrantsViewRepository;
    private final ChiefWarrantViewRepository chiefWarrantViewRepository;
    private final WarrantTrackingViewRepository warrantTrackingViewRepository;

    public WarrantServiceImpl(OrdersService ordersService,
                              WarrantRepository warrantRepository,
                              EmployeeUsersService employeeUsersService,
                              UserService userService, ManagerService managerService,
                              OrderCreateWarrantsRepository orderCreateWarrantsRepository,
                              ManagersWarrantsViewRepository managersWarrantsViewRepository,
                              ChiefWarrantViewRepository chiefWarrantViewRepository,
                              WarrantTrackingViewRepository warrantTrackingViewRepository) {
        this.ordersService = ordersService;
        this.warrantRepository = warrantRepository;
        this.employeeUsersService = employeeUsersService;
        this.userService = userService;
        this.managerService = managerService;
        this.orderCreateWarrantsRepository = orderCreateWarrantsRepository;
        this.managersWarrantsViewRepository = managersWarrantsViewRepository;
        this.chiefWarrantViewRepository = chiefWarrantViewRepository;
        this.warrantTrackingViewRepository = warrantTrackingViewRepository;
    }

    @Override
    @Transactional
    public Optional<Nalozi> create(String username, Long orderId) {
        Korisnik korisnik = this.userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        VraboteniSeKorisnici vraboteni = this.employeeUsersService.findByUserId(korisnik.getIdKorisnik());
        Vraboteni vraboteni1 = vraboteni.getVraboteni();
        Menadzeri menadzer = this.managerService.findById(vraboteni.getIdVraboten());
        Nalozi nalozi = new Nalozi(menadzer, vraboteni1, Date.from(Instant.now()));
        this.warrantRepository.save(nalozi);
        Naracka naracka = this.ordersService.findById(orderId);
        NaloziKreiraNaracka naloziKreiraNaracka = new NaloziKreiraNaracka(
                nalozi, naracka);
        this.orderCreateWarrantsRepository.save(naloziKreiraNaracka);
        nalozi.setNaloziKreiraNaracka(naloziKreiraNaracka);
        return Optional.of(this.warrantRepository.save(nalozi));
    }

    @Override
    public Optional<Nalozi> endWarrant(Long warrantId) {
        Nalozi nalozi = this.warrantRepository.findById(warrantId)
                .orElseThrow(() -> new WarrantNotFoundException(warrantId));
        nalozi.setKrajnaData(Date.from(Instant.now()));
        return Optional.of(this.warrantRepository.save(nalozi));
    }

    @Override
    public List<ManagersWarrantsView> fetchAll() {
        return this.managersWarrantsViewRepository.findAll();
    }

    @Override
    public Optional<ChiefsWarrantView> findByWarrantId(Long warrantId) {
        return this.chiefWarrantViewRepository.findById(warrantId);
    }

    @Override
    public List<WarrantTrackingView> findById(Long id) {
        return this.warrantTrackingViewRepository.findAllById_WarrantId(id);
    }


}
