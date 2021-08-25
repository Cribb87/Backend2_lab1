package se.nackademin.java20.lab1.controllers;

import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.services.AccountService;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping(path = "/create")
    public @ResponseBody String createAccount (@ResponseBody Account account) {
        accountService.saveAccount(account);
        return "Account created";
    }

}