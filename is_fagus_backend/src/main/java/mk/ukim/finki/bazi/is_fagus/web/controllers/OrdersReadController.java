package mk.ukim.finki.bazi.is_fagus.web.controllers;


import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.views.ManagerOrderView;
import mk.ukim.finki.bazi.is_fagus.model.views.OrderExtraPartsView;
import mk.ukim.finki.bazi.is_fagus.model.views.OrderPercentDoneView;
import mk.ukim.finki.bazi.is_fagus.model.views.OrdersView;
import mk.ukim.finki.bazi.is_fagus.service.OrdersService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/order")
public class OrdersReadController {

    private final OrdersService ordersService;
    private final UserService userService;

    public OrdersReadController(OrdersService ordersService, UserService userService) {
        this.ordersService = ordersService;

        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<OrdersView> findAllByClientId(@AuthenticationPrincipal String username) throws Exception {
        Optional<Klienti> client=this.userService.findClientByUsername(username);
        if(client.isPresent()) {
            return this.ordersService.findAllByClientId(client.get().getIdKlient());
        }
        throw new Exception("Error");
    }

    @GetMapping("/parts/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<OrderExtraPartsView> viewForOrdersExtraParts(@PathVariable Long id){
        return this.ordersService.extraPartsViewByOrderId(id);
    }

    @GetMapping("/percent/my")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<OrderPercentDoneView> findAllPercentPerOrderDoneByClient(@AuthenticationPrincipal String username){
        return this.ordersService.findAllPercentPerOrdersDoneByClientId(username);
    }


    @GetMapping("/percent")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<OrderPercentDoneView> findAllPercentPerOrderDone(){
        return this.ordersService.findAllPercentPerOrdersDone();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<ManagerOrderView> findAllForManager(){
        return this.ordersService.findAllOrdersForManager();
    }

    @GetMapping("/percent/{id}")
    public ResponseEntity<OrderPercentDoneView> findPercentDoneViewByOrderId(@PathVariable Long id){
        return this.ordersService.findOrderPercentDoneByOrderId(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
