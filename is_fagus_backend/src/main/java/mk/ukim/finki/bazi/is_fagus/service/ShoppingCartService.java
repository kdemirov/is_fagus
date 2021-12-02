package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Mebel;
import mk.ukim.finki.bazi.is_fagus.model.ShoppingCart;
import mk.ukim.finki.bazi.is_fagus.model.views.ShoppingCartView;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    /**
     * @param username
     * @return object of shoppingCart for taking the current ShoppingCart for the logged in Client
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     */
    ShoppingCart getActiveShoppingCart(String username);

    /**
     * @param username Username for current logged in Client
     * @param furnitureId selected furnitureId in frontend
     * @return Optional of the shoppingcart if the product is placed successfully
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurnutureNotFoundException
     */
    Optional<ShoppingCart> addProductToShoppingCart(String username, Long furnitureId);

    /**
     * @param username Current logged in username of Clients
     * @return List of shoppingcart products for an easy shown way in frontend
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     */
    List<ShoppingCartView> findAllByClientUsername(String username);


    /**
     * @param id
     * @return return optional of ShoppingCart if the shoppingCart exist
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.ShoppingCardNotFoundException
     */
    Optional<ShoppingCart> findById(Long id);

    /**
     * @param id Delete the shopping cart by finising the order
     */
    void deleteById(Long id);

    /**
     * @param cardId given cartId
     * @param furnitureId selected product from shopping cart
     * @return Optional of shopping cart if the item is removed successfully
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.ShoppingCardNotFoundException
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurnutureNotFoundException
     */
    Optional<ShoppingCart> deleteFurnitureItemInCard(Long cardId, Long furnitureId);
}
