package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.repositories.DungeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DungeonService {

    private final DungeonRepository dungeonRepository;

    @Autowired
    public DungeonService(DungeonRepository dungeonRepository) {
        this.dungeonRepository = dungeonRepository;
    }

    public List<Dungeon> allDungeon() {
        List<Dungeon> dungeons = dungeonRepository.findAllDungeonsWithEncounters();
        System.out.println(dungeons.get(0).toString());
        return dungeonRepository.findAllDungeonsWithEncounters();
    }
}