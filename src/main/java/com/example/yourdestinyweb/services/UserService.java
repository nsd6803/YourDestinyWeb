package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return this.repository.getAll();
    }

    public User getByLogin(String login) {
        return this.repository.getByLogin(login);
    }

    public String checkUser(User user) {
        User u = getByLogin(user.getLogin());
        if (Objects.isNull(u)) {
            return "Not found";
        }
        else if (!Objects.equals(u.getPassword(), user.getPassword())){
            return "Incorrect password";
        }
        else{
            return "ok";
        }
    }
}
