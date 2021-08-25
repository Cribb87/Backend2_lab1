package se.nackademin.java20.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.services.AccountService;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/create")
    public String createAccount (@RequestBody Account account) {
        accountService.saveAccount(account);
        return "Account created";
    }

    @GetMapping(path = "/get")
    public List<Account> getAllAccounts (){
        return accountService.getAllAccounts();
    }

}
