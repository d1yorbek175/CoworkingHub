package org.example.coworkhub.repository;

import org.example.coworkhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {
    boolean existByEmail(String email);
}
