package se.nackademin.java20.lab1.services;

import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.repositories.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }
}
