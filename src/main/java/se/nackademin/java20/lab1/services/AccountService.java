package se.nackademin.java20.lab1.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public Account findAccountById(long id) {
        return repository.getById(id);
    }
}
