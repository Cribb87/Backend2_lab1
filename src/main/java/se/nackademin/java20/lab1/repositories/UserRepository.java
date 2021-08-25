package se.nackademin.java20.lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.java20.lab1.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
