package mk.ukim.finki.bazi.is_fagus.web.controllers;


import mk.ukim.finki.bazi.is_fagus.service.ClientService;
import org.springframework.web.bind.annotation.*;



@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/clients")
public class ClientsReadController {

    private final ClientService clientService;

    public ClientsReadController(ClientService clientService) {
        this.clientService = clientService;
    }

}
