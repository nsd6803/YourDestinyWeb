package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.services.ArmorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armor")
@Tag(name = "Броня", description = "вся информация по броне")
public class ArmorController {
    private final ArmorService armourService;

    public ArmorController(ArmorService armourService) {
        this.armourService = armourService;
    }
    @Operation(
            summary = "Получить полный список брони")
    @GetMapping("/all")
    public List<Armor> all_armour(Model model) {
        return armourService.allArmour();
    }

    @Operation(
            summary = "Получить информацию по броне по id")
    @GetMapping("/{id}")
    public ResponseEntity<Armor> armour(Model model, @PathVariable Long id) {
        Armor armor = armourService.find_Armour(id).getBody();

        if (armor != null) {
            return ResponseEntity.ok(armor);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @Operation(
            summary = "Добавить броню")
    @PostMapping("/new")
    public ResponseEntity<Armor> add_armour(@RequestBody Armor armor) {
        try {
            armourService.saveArmor(armor);
            return ResponseEntity.ok(armor);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @Operation(
            summary = "Удалить броню по id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArmor(@PathVariable Long id) {
        try {
            armourService.deleteArmorById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(
            summary = "Изменить информацию по броне (требуется в body указать новую информацию)")
    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateArmor(@PathVariable Long id, @RequestBody Armor updatedArmor) {
        try {
            armourService.updateArmor(id, updatedArmor);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
