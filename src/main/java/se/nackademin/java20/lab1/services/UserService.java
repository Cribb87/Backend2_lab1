package se.nackademin.java20.lab1.services;

import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.models.User;
import se.nackademin.java20.lab1.repositories.UserRepository;

/**
 * Created by Christoffer Grännby
 * Date: 2021-08-25
 * Time: 10:15
 * Project: Övningsuppgifter
 * Copyright: MIT
 */
public class UserService {

    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
