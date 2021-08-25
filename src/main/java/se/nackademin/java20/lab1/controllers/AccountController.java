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

    @PostMapping(path = "/create/{userId}/{balance}")
    public String createAccount (@PathVariable Long userId, @PathVariable double balance) {
        User user = userService.findUserById(userId);
        if (user == null) {
            return "That user does not exist";
        }
        else {
            Account account = new Account(user, balance);
            accountService.saveAccount(account);
            return "Account created";
        }
    }

    @GetMapping(path = "/get")
    public List<Account> getAllAccounts (){
        return accountService.getAllAccounts();
    }

    @PostMapping(path = "/deposit/{id}/{amount}")
    public String depositIntoAccount(@PathVariable long id, @PathVariable double amount) {
        Account account = accountService.findAccountById(id);
        account.deposit(amount);
        accountService.saveAccount(account);
        return "Success.";
    }

    @PostMapping(path = "/withdraw/{id}/{amount}")
    public String withdrawFromAccount(@PathVariable long id, @PathVariable double amount) {
        Account account = accountService.findAccountById(id);
        String messageToReturn;
        if (account.getBalance() < amount) {
            messageToReturn = "You can't withdraw " + amount + " since your balance is " + account.getBalance();
        }
        else {
            account.withdraw(amount);
            accountService.saveAccount(account);
            messageToReturn = "Success.";
        }
       
        return messageToReturn;
    }
}
