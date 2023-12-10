package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.services.ArmorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/armor")
public class ArmorController {
    private final ArmorService armourService;

    public ArmorController(ArmorService armourService) {
        this.armourService = armourService;
    }

    @GetMapping("/all")
    public List<Armor> all_armour(Model model) {
        return armourService.allArmour();
    }

}
