package mk.ukim.finki.bazi.is_fagus.service.impl;

import mk.ukim.finki.bazi.is_fagus.model.*;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.OrderExtraPartsDto;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.FurniturePartDoesNotExistException;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.OrderNotExistException;
import mk.ukim.finki.bazi.is_fagus.model.views.*;
import mk.ukim.finki.bazi.is_fagus.repository.*;
import mk.ukim.finki.bazi.is_fagus.repository.views.ChiefOrderViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.ManagerOrdersViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.OrderExtraPartsViewRepository;
import mk.ukim.finki.bazi.is_fagus.repository.views.OrdersViewRepository;
import mk.ukim.finki.bazi.is_fagus.service.ClientService;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;
import mk.ukim.finki.bazi.is_fagus.service.OrdersService;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final ClientService clientService;
    private final FurnitureService furnitureService;
    private final OrdersRepository ordersRepository;
    private final OrdersViewRepository ordersViewRepository;
    private final OrderContainsFurnitureRepository orderContainsFurnitureRepository;
    private final FurniturePartsRepository furniturePartsRepository;
    private final ExtraPartsForOrderRepository extraPartsForOrderRepository;
    private final OrderExtraPartsViewRepository orderExtraPartsViewRepository;
    private final OrderPercentDoneViewRepository orderPercentDoneViewRepository;
    private final UserService userService;
    private final ManagerOrdersViewRepository managerOrdersViewRepository;
    private final ChiefOrderViewRepository chiefOrderViewRepository;

    public OrdersServiceImpl(ClientService clientService,
                             FurnitureService furnitureService,
                             OrdersRepository ordersRepository,
                             OrdersViewRepository ordersViewRepository,
                             OrderContainsFurnitureRepository orderContainsFurnitureRepository,
                             FurniturePartsRepository furniturePartsRepository,
                             ExtraPartsForOrderRepository extraPartsForOrderRepository,
                             OrderExtraPartsViewRepository orderExtraPartsViewRepository,
                             OrderPercentDoneViewRepository orderPercentDoneViewRepository,
                             UserService userService, ManagerOrdersViewRepository managerOrdersViewRepository,
                             ChiefOrderViewRepository chiefOrderViewRepository) {
        this.clientService = clientService;
        this.furnitureService = furnitureService;
        this.ordersRepository = ordersRepository;
        this.ordersViewRepository = ordersViewRepository;
        this.orderContainsFurnitureRepository = orderContainsFurnitureRepository;
        this.furniturePartsRepository = furniturePartsRepository;
        this.extraPartsForOrderRepository = extraPartsForOrderRepository;
        this.orderExtraPartsViewRepository = orderExtraPartsViewRepository;
        this.orderPercentDoneViewRepository = orderPercentDoneViewRepository;
        this.userService = userService;
        this.managerOrdersViewRepository = managerOrdersViewRepository;
        this.chiefOrderViewRepository = chiefOrderViewRepository;
    }

    @Override
    public Optional<Naracka> order(String username, List<Long> array, List<Integer> quantities) {

        List<Mebel> list = this.furnitureService.findAllByIds(array);
        Klienti client = this.userService.findClientByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        ;
        Naracka naracka = this.ordersRepository.save(new Naracka(client,
                Date.from(Instant.now()), "Test", ""));
        NarackaSeSostoiOdMebel narackaSeSostoiOdMebel = null;
        for (int i = 0; i < list.size(); i++) {
            narackaSeSostoiOdMebel = new NarackaSeSostoiOdMebel(
                    new NarackaSeSostoiOdMebelId(list.get(i).getIdMebel(),
                            naracka.getIdNaracka()),
                    list.get(i),
                    naracka,
                    quantities.get(i)

            );
            naracka.getNarackaSeSostoiOdMebelsSostoiOdMebel().add(narackaSeSostoiOdMebel);
            this.orderContainsFurnitureRepository.save(narackaSeSostoiOdMebel);
        }
        ;
        return Optional.of(this.ordersRepository.save(naracka));
    }


    @Override
    public Optional<Naracka> orderShipped(Long orderId) {
        Naracka naracka = this.ordersRepository.findById(orderId).orElseThrow(() -> new OrderNotExistException(orderId));
        naracka.setDatumIsporacana(Date.from(Instant.now()));
        return Optional.of(this.ordersRepository.save(naracka));
    }

    @Override
    public Naracka findById(Long id) {
        return this.ordersRepository.findById(id)
                .orElseThrow(() -> new OrderNotExistException(id));
    }

    @Override
    public List<OrdersView> findAllByClientId(Long clientId) {
        return this.ordersViewRepository.findAllByClientId(clientId);
    }

    @Override
    public Optional<Naracka> orderExtraParts(OrderExtraPartsDto dto) {
        Naracka naracka = this.ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new OrderNotExistException(dto.getOrderId()));
        Delovi del = this.furniturePartsRepository.findById(dto.getPartId())
                .orElseThrow(() -> new FurniturePartDoesNotExistException(dto.getPartId()));
        DopolniteliDeloviZaNaracka dopolniteliDeloviZaNaracka =
                new DopolniteliDeloviZaNaracka(
                        new DopolniteliDeloviZaNarackaId(naracka.getIdNaracka(), del.getIdDel()),
                        del,
                        naracka,
                        dto.getQuantity()
                );
        this.extraPartsForOrderRepository.save(dopolniteliDeloviZaNaracka);
        naracka.getDopolniteliDeloviZaNarackas().add(dopolniteliDeloviZaNaracka);
        return Optional.of(naracka);
    }

    @Override
    public List<OrderExtraPartsView> extraPartsViewByOrderId(Long orderId) {
        return this.orderExtraPartsViewRepository.findAllByOrderExtraPartsId_OrderId(orderId);
    }

    @Override
    public List<OrderPercentDoneView> findAllPercentPerOrdersDone() {
        return this.orderPercentDoneViewRepository.findAll();
    }

    @Override
    public List<OrderPercentDoneView> findAllPercentPerOrdersDoneByClientId(String username) {
        Klienti klienti = this.userService.findClientByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return this.orderPercentDoneViewRepository.findAllByClientId(klienti.getIdKlient());
    }

    @Override
    public List<ManagerOrderView> findAllOrdersForManager() {
        return this.managerOrdersViewRepository.findAll();
    }

    @Override
    public List<ChiefOrderView> findAllByWarrantId(Long orderId) {
        return this.chiefOrderViewRepository.findAllByOrderId(orderId);
    }

    @Override
    public Optional<OrderPercentDoneView> findOrderPercentDoneByOrderId(Long orderId) {
        return this.orderPercentDoneViewRepository.findById(orderId);
    }


}
