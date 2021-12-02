package mk.ukim.finki.bazi.is_fagus.web.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//todo change that in production
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/clients")
public class ClientsController {


}
