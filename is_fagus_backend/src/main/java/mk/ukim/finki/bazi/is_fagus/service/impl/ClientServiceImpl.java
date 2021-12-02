package mk.ukim.finki.bazi.is_fagus.service.impl;


import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.exceptions.UserNotFoundException;
import mk.ukim.finki.bazi.is_fagus.repository.ClientsJpaRepository;
import mk.ukim.finki.bazi.is_fagus.repository.OrdersRepository;
import mk.ukim.finki.bazi.is_fagus.service.ClientService;
import mk.ukim.finki.bazi.is_fagus.service.FurnitureService;

import org.springframework.stereotype.Service;



@Service
public class ClientServiceImpl implements ClientService {

    private final ClientsJpaRepository clientsJpaRepository;
    private final OrdersRepository ordersRepository;
    private final FurnitureService furnitureService;

    public ClientServiceImpl(ClientsJpaRepository clientsJpaRepository,
                             OrdersRepository ordersRepository,
                             FurnitureService furnitureService) {
        this.clientsJpaRepository = clientsJpaRepository;
        this.ordersRepository = ordersRepository;
        this.furnitureService = furnitureService;
    }


    @Override
    public Klienti findById(Long clientId) {
       return  this.clientsJpaRepository.findById(clientId).orElseThrow(()-> new UserNotFoundException(clientId));
    }
}
