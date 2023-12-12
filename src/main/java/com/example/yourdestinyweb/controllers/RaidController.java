package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.services.DungeonService;
import com.example.yourdestinyweb.services.RaidService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Рейды", description = "вся информация по рейдам")
@RestController
@RequestMapping("/raid")
public class RaidController {
    private final RaidService raidService;

    public RaidController(RaidService raidService) {
        this.raidService = raidService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Raid>> allRaid() {
        List<Raid> dungeons = raidService.allRaid();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dungeons);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Raid> raid(Model model, @PathVariable Long id) {
        Raid raid = raidService.find_Raid(id).getBody();

        if (raid != null) {
            return ResponseEntity.ok(raid);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Raid> add_Raid(@RequestBody Raid raid) {
        try {
            raidService.saveRaid(raid);
            return ResponseEntity.ok(raid);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRaid(@PathVariable Long id) {
        try {
            raidService.deleteRaidById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateRaid(@PathVariable Long id, @RequestBody Raid updatedRaid) {
        try {
            raidService.updateRaid(id, updatedRaid);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
