package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.services.RaidService;
import com.example.yourdestinyweb.services.TriumphService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/triumph")
public class TriumphController {
    private final TriumphService triumphService;

    public TriumphController(TriumphService triumphService) {
        this.triumphService = triumphService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Triumph>> allRaid() {
        List<Triumph> dungeons = triumphService.allTriumph();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dungeons);
    }
}
