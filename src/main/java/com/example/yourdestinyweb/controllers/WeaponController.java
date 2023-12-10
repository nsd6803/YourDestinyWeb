package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.Weapon;
import com.example.yourdestinyweb.services.TriumphService;
import com.example.yourdestinyweb.services.WeaponService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/weapon")
public class WeaponController {
    private final WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Weapon>> allWeapon() {
        List<Weapon> dungeons = weaponService.allWeapon();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dungeons);
    }
}