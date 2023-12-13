package com.example.yourdestinyweb.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/auth")
    public String loginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication: " + auth);

        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/swagger-ui/index.html#/";
        }
        return "auth";
    }
}