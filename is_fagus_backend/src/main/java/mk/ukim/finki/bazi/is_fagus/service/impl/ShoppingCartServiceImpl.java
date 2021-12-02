package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.Mebel;
import mk.ukim.finki.bazi.is_fagus.model.ShoppingCart;
import mk.ukim.finki.bazi.is_fagus.model.enumerations.ShoppingCardStatus;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.ShoppingCardNotFoundException;
import mk.ukim.finki.bazi.is_fagus.model.views.ShoppingCartView;
import mk.ukim.finki.bazi.is_fagus.repository.ShoppingCartRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.ShopingCartViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.ClientService;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;
import mk.ukim.finki.bazi.is_fagus.service.ShoppingCartService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ClientService clientService;
    private final UserService userService;
    private final FurnitureService furnitureService;
    private final ShopingCartViewRepository shopingCartViewRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ClientService clientService,
                                   UserService userService,
                                   FurnitureService furnitureService,
                                   ShopingCartViewRepository shopingCartViewRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.clientService = clientService;
        this.userService = userService;
        this.furnitureService = furnitureService;
        this.shopingCartViewRepository = shopingCartViewRepository;
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {

        Klienti client = this.userService.findClientByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return this.shoppingCartRepository.findByClientAndAndStatus(
                client,
                ShoppingCardStatus.CREATED
        ).orElseGet(() ->
                this.shoppingCartRepository.save(
                        new ShoppingCart(client)));

    }

    @Override
    public Optional<ShoppingCart> addProductToShoppingCart(String username, Long furnitureId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Mebel mebel = this.furnitureService.findById(furnitureId);
        shoppingCart.getFurnitures().add(mebel);
        return Optional.of(this.shoppingCartRepository.save(shoppingCart));
    }

    @Override
    public List<ShoppingCartView> findAllByClientUsername(String username) {
        ShoppingCart cart = this.getActiveShoppingCart(username);
        return this.shopingCartViewRepository.findAllById_ShoppingCartId(cart.getId());
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.shoppingCartRepository.deleteById(id);
    }

    @Override
    public Optional<ShoppingCart> deleteFurnitureItemInCard(Long cardId, Long furnitureId) {
        ShoppingCart cart = this.findById(cardId)
                .orElseThrow(() -> new ShoppingCardNotFoundException(cardId));

        Mebel mebel = this.furnitureService.findById(furnitureId);
        cart.getFurnitures().remove(cart);
        return Optional.of(this.shoppingCartRepository.save(cart));
    }

}
