package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
