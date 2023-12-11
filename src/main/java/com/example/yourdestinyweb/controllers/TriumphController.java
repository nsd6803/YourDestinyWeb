package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.TriumphTasks;
import com.example.yourdestinyweb.services.RaidService;
import com.example.yourdestinyweb.services.TriumphService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/triumph")
public class TriumphController {
    private final TriumphService triumphService;

    public TriumphController(TriumphService triumphService) {
        this.triumphService = triumphService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Triumph>> allTriumph() {
        List<Triumph> triumph = triumphService.allTriumph();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(triumph);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Triumph> triumph(Model model, @PathVariable Long id) {
        Triumph triumph = triumphService.find_Triumph(id).getBody();

        if (triumph != null) {
            return ResponseEntity.ok(triumph);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Triumph> add_Triumph(@RequestBody Triumph triumph) {
        try {
            triumphService.saveTriumph(triumph);
            return ResponseEntity.ok(triumph);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTriumph(@PathVariable Long id) {
        try {
            triumphService.deleteTriumphById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateTriumph(@PathVariable Long id, @RequestBody Triumph updatedTriumph) {
        try {
            triumphService.updateTriumph(id, updatedTriumph);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
