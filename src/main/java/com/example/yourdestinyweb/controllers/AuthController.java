package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.services.LoginRequest;
import com.example.yourdestinyweb.services.LoginResponse;
import com.example.yourdestinyweb.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody LoginResponse login(@RequestBody User user) {
        String user2 = userService.checkUser(user);
        if (Objects.equals(user2, "ok")) {
            return new LoginResponse("ok");
        } else {
            return new LoginResponse("error");
        }
    }
}