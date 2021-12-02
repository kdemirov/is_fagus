package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.Mebel;
import mk.ukim.finki.bazi.is_fagus.model.ShoppingCart;
import mk.ukim.finki.bazi.is_fagus.model.views.ShoppingCartView;
import mk.ukim.finki.bazi.is_fagus.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/shopping-cart")
public class ShoppingCartReadController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartReadController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<ShoppingCartView> getOrCreateShoppingCart(@AuthenticationPrincipal String username){
       List<ShoppingCartView> shoppingCartViews = this.shoppingCartService.findAllByClientUsername(username);
        return shoppingCartViews;
    }
}
