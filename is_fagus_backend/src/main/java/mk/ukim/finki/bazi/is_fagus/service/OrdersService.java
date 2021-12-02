package mk.ukim.finki.bazi.is_fagus.service;

import mk.ukim.finki.bazi.is_fagus.model.Naracka;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderExtraPartsDto;
import mk.ukim.finki.bazi.is_fagus.model.views.*;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    /**
     * @param username  current logged in client
     * @param idS list of ids of selected products
     * @param quanties list od ids of selected quantity
     * @return Optional of naracka if the order is successfully
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     */
    Optional<Naracka> order(String username, List<Long> idS,List<Integer> quanties);

    /**
     * @param orderId the clients chooses that the order is delivered and sends an id of the order
     * @return Optional of Naracka if the order if the date is set to current_date
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     */
    Optional<Naracka> orderShipped(Long orderId);

    /**
     * @param id find Naracka by given id
     * @return Naracka
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     */
    Naracka findById(Long id);

    /**
     * @param clientId
     * @return  List of current orders of the logged in client within view
     */
    List<OrdersView> findAllByClientId(Long clientId);

    /**
     * @param dto Data Transfer object which contains information about the extra parts for current order
     * @return Optional of Naracka if the order is successfully updated
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException
     */
    Optional<Naracka> orderExtraParts(OrderExtraPartsDto dto);

    /**
     * @param orderId
     * @return View for extra parts for an easy showing way in front end
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException
     */
    List<OrderExtraPartsView> extraPartsViewByOrderId(Long orderId);

    /**
     * @return List of OrderPercentDoneView if the client has no orders that are on progress
     */
    List<OrderPercentDoneView> findAllPercentPerOrdersDone();

    /**
     * @param username
     * @return  List of OrderPercentDoneView for the current logged in Client
     */
    List<OrderPercentDoneView> findAllPercentPerOrdersDoneByClientId(String username);

    /**
     * @return List of ManagerOrderView for an easy shown way in frontend
     */
    List<ManagerOrderView> findAllOrdersForManager();

    /**
     * @param orderId
     * @return List of ChiefOrderView for an easy shown way in frontend
     */
    List<ChiefOrderView> findAllByWarrantId(Long orderId);

    /**
     * @param orderId
     * @return Find OrderPercentDoneView for order by given orderId
     * @throws mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException
     */
    Optional<OrderPercentDoneView> findOrderPercentDoneByOrderId(Long orderId);

}
