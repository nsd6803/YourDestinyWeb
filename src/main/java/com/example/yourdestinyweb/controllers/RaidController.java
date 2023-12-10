package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.services.DungeonService;
import com.example.yourdestinyweb.services.RaidService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
