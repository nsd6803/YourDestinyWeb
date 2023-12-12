package com.example.yourdestinyweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @GetMapping("/user-info")
    public String user_info() {
        return "user-info";
    }
}