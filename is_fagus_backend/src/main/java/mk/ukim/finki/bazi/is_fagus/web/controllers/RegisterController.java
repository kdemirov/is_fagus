package mk.ukim.finki.bazi.is_fagus.web.controllers;

import mk.ukim.finki.bazi.is_fagus.model.Klienti;
import mk.ukim.finki.bazi.is_fagus.model.dto.ClientDto;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//todo change that in production
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/client")
    public ResponseEntity<Klienti> register(@RequestBody ClientDto clientDto){

       return  this.userService.registerClient(clientDto)
               .map(ResponseEntity::ok)
               .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
