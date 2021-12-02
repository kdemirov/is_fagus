package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.ShoppingCart;
import mk.ukim.finki.bazi.is_fagus.model.dto.AddToShoppingCartDto;
import mk.ukim.finki.bazi.is_fagus.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> addFurnitureToShoppingCart(@AuthenticationPrincipal String username,
                                                                   @RequestBody AddToShoppingCartDto dto){
        return this.shoppingCartService.addProductToShoppingCart(username,dto.getFurnitureId())
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/{shoppingCartId}/{idMebel}")
    public ResponseEntity deleteFurnitureFromCart(@PathVariable Long shoppingCardId,
                                                  @PathVariable Long idMebel){
        return this.shoppingCartService.deleteFurnitureItemInCard(shoppingCardId,idMebel)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
         this.shoppingCartService.deleteById(id);
         if(this.shoppingCartService.findById(id).isEmpty()){
             return ResponseEntity.ok().build();
         }
         return ResponseEntity.notFound().build();
    }
}
