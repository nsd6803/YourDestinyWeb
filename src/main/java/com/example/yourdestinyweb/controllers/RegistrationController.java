package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Role;
import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, String date, Model model) {
        System.out.println(date);
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User exist!");
            return "/registration";
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        if (Objects.equals(user.getUsername(), "Adminka"))
            user.setRoles(new HashSet<>(Arrays.asList(Role.USER, Role.ADMIN)));
        else user.setRoles(Collections.singleton(Role.USER));

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date b = formatter.parse(date);
            user.setBirthday(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userRepository.save(user);
        return "redirect:/login";
    }


}
