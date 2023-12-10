//package com.example.yourdestinyweb.controllers;
//
//import com.example.yourdestinyweb.models.Role;
//import com.example.yourdestinyweb.models.User;
//import com.example.yourdestinyweb.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//
//@Controller
//@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('ADMIN')")
//public class UserController {
//    private final UserService userService;
//
//    @GetMapping
//    public String admin(Model model) {
//        return "admin";
//    }
//
//    @GetMapping("/profile")
//    public String profile(Model model, Principal principal) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        User user = userService.getUserByPrincipal(principal);
//        Date date = user.getBirthday() != null ? user.getBirthday() : new Date();
//        model.addAttribute("user", user);
//        model.addAttribute("birthday", formatter.format(date));
//        return "profile";
//    }
//
//    @GetMapping("/users")
//    public String userList(Model model) {
//        model.addAttribute("users", userService.list());
//        return "user-list";
//    }
//
//    @GetMapping("/users/{user}")
//    public String userEditForm(@PathVariable User user, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("roles", Role.values());
//        return "user-edit";
//    }
//
//    @PostMapping("/users/edit")
//    public String userSave(
//            @RequestParam String username,
//            @RequestParam Map<String, String> form,
//            @RequestParam("userId") User user
//    ) {
//        userService.userEdit(username, form, user);
//
//        return "redirect:/admin/users";
//    }
//
//    @PostMapping("/users/put")
//    public String userSave(@RequestParam("birthday") String birthday,
//                           @RequestParam("fullname") String fullname,
//                           @RequestParam("userId") User user
//    ) {
//        userService.userEdit(birthday, fullname, user);
//        System.out.println(birthday + fullname);
//
//        return "redirect:/";
//    }
//
//}
//