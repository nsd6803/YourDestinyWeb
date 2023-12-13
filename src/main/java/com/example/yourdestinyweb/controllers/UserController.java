package com.example.yourdestinyweb.controllers;


import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//чтобы админ мог смотреть информацию о каком-либо пользователе
@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("user-info/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUserFromBd(id);
        return ResponseEntity.ok(user);
    }
}
