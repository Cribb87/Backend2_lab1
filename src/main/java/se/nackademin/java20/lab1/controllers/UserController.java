package se.nackademin.java20.lab1.controllers;

import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.models.User;
import se.nackademin.java20.lab1.services.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    private  UserService userService;

    @PostMapping(path = "/create")
    public String createUser (@RequestBody User u) {
        userService.saveUser(u);
        return "User created";
    }
}
