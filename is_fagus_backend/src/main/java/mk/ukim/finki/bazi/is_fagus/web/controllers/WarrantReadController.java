package mk.ukim.finki.bazi.is_fagus.web.controllers;


import mk.ukim.finki.bazi.is_fagus.model.views.*;
import mk.ukim.finki.bazi.is_fagus.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/warrant")
public class WarrantReadController {

    private final WarrantService warrantService;
    private final OrdersService ordersService;
    private final FurniturePartsService furniturePartsService;
    private final MachineService machine;
    private final EmployeeService employeeService;

    public WarrantReadController(WarrantService warrantService,
                                 OrdersService ordersService,
                                 FurniturePartsService furniturePartsService,
                                 MachineService machine,
                                 EmployeeService employeeService) {
        this.warrantService = warrantService;
        this.ordersService = ordersService;
        this.furniturePartsService = furniturePartsService;
        this.machine = machine;
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_CHIEF')")
    public List<ManagersWarrantsView> fetchAll() {
        return this.warrantService.fetchAll();

    }
    @GetMapping("/tracking/{id}")
    public List<WarrantTrackingView> findAllById(@PathVariable Long id){
       List<WarrantTrackingView> list=this.warrantService.findById(id);
        return this.warrantService.findById(id);
    }
    @GetMapping("/{warrantId}")
    @PreAuthorize("hasRole('ROLE_CHIEF')")
    public ResponseEntity<ChiefsWarrantView> findAllByWarrantId(@PathVariable Long warrantId) {
        Optional<ChiefsWarrantView> warrantView = this.warrantService.findByWarrantId(warrantId);
        return warrantView.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/orders/{orderId}")
    @PreAuthorize("hasRole('ROLE_CHIEF')")
    public List<ChiefOrderView> findAllOrdersByWarrantId(@PathVariable Long orderId) {

        return this.ordersService.findAllByWarrantId(orderId);
    }

    @GetMapping("/parts")
    @PreAuthorize("hasRole('ROLE_CHIEF')")
    public List<ChiefPartsView> findAllPartsByFurnitureId() {
        return this.furniturePartsService.findAllByFurnitureId();
    }

    @GetMapping("/machines")
    @PreAuthorize("hasRole('ROLE_CHIEF')")
    public List<ChiefMachineView> findAllMachines() {
        return this.machine.findAllMachineView();
    }

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ROLE_CHIEF')")
    public List<ChiefEmployeeView> findAllEmployees() {
        return this.employeeService.findAll();
    }
}
