package mk.ukim.finki.bazi.is_fagus.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.bazi.is_fagus.model.dto.LoginDto;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//todo change that in production
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void login(@RequestBody LoginDto loginDto) throws JsonProcessingException {

    }

}
