package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.services.DungeonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dungeon")
public class DungeonController {

    private final DungeonService dungeonService;

    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dungeon>> allDungeon() {
        List<Dungeon> dungeons = dungeonService.allDungeon();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dungeons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dungeon> dungeon(Model model, @PathVariable Long id) {
        Dungeon dungeon = dungeonService.find_Dungeon(id).getBody();

        if (dungeon != null) {
            return ResponseEntity.ok(dungeon);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Dungeon> add_Dungeon(@RequestBody Dungeon dungeon) {
        try {
            dungeonService.saveDungeon(dungeon);
            return ResponseEntity.ok(dungeon);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDungeon(@PathVariable Long id) {
        try {
            dungeonService.deleteDungeonById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateDungeon(@PathVariable Long id, @RequestBody Dungeon updatedDungeon) {
        try {
            dungeonService.updateDungeon(id, updatedDungeon);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}