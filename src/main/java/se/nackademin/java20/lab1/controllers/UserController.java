package se.nackademin.java20.lab1.controllers;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.nackademin.java20.lab1.services.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create")
    public @ResponseBody
    String createUser (@ResponseBody User user) {
        userService.saveUser(user);
        return "User created";
    }
}
