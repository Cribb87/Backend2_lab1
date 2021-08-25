package se.nackademin.java20.lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.java20.lab1.models.Account;

/**
 * Created by Christoffer Grännby
 * Date: 2021-08-25
 * Time: 10:13
 * Project: Övningsuppgifter
 * Copyright: MIT
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findById(String id);
}
