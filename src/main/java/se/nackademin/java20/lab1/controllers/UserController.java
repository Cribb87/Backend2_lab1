package se.nackademin.java20.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.models.User;
import se.nackademin.java20.lab1.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping(path = "/create")
    public String createUser (@RequestBody User u) {
        userService.saveUser(u);
        return "User created";
    }

    @GetMapping(path = "/get")
    public List<User> getAllUsers (){
        return userService.getAllUsers();
    }
}
