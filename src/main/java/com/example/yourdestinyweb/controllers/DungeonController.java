package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.services.DungeonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}