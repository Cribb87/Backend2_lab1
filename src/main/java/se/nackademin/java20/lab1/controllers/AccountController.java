package se.nackademin.java20.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.models.User;
import se.nackademin.java20.lab1.services.AccountService;
import se.nackademin.java20.lab1.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public String createAccount (@RequestBody Account account) {
        //Kan ej hämta kund från ett konto som inte finns. Hur gör vi?
        //Måste leta efter användaren i databasen via användarens id på något annat sätt
        User user = userService.findUserById(account.getUser().getId());
        if(user == null){
            return "User doesn't exist";
        }
        else {
            accountService.saveAccount(account);
            return "Account created";
        }
    }

    @GetMapping(path = "/get")
    public List<Account> getAllAccounts (){
        return accountService.getAllAccounts();
    }

}
