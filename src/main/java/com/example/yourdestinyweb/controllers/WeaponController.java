package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.Weapon;
import com.example.yourdestinyweb.models.WeaponStats;
import com.example.yourdestinyweb.services.TriumphService;
import com.example.yourdestinyweb.services.WeaponService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Оружие", description = "вся информация по оружию")
@RestController
@RequestMapping("/weapon")
public class WeaponController {
    private final WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Weapon>> allWeapon() {
        List<Weapon> weapon = weaponService.allWeapon();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(weapon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> weapon(Model model, @PathVariable Long id) {
        Weapon weapon = weaponService.find_Weapon(id).getBody();

        if (weapon != null) {
            return ResponseEntity.ok(weapon);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Weapon> add_Weapon(@RequestBody Weapon weapon) {
        try {
            weaponService.saveWeapon(weapon);
            return ResponseEntity.ok(weapon);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable Long id) {
        try {
            weaponService.deleteWeaponById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateWeapon(@PathVariable Long id, @RequestBody Weapon updatedWeapon) {
        try {
            weaponService.updateWeapon(id, updatedWeapon);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/stats/{id}")
    public ResponseEntity<Void> updateWeaponStats(@PathVariable Long id, @RequestBody WeaponStats updatedWeaponStats) {
        try {
            weaponService.updateWeaponStats(id, updatedWeaponStats);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}