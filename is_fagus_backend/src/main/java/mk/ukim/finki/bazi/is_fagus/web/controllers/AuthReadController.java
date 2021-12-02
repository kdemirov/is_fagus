package mk.ukim.finki.bazi.is_fagus.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.bazi.is_fagus.model.dto.UserDetailsDto;
import mk.ukim.finki.bazi.is_fagus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
//todo change that in production
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class AuthReadController {

    private final UserService userService;

    public AuthReadController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDetailsDto> getCurrentUser(HttpServletRequest request) throws JsonProcessingException {
        Optional<UserDetailsDto> user = this.userService.getCurrentUser(request);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
