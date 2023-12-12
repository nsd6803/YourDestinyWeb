package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.DungeonEncounters;
import com.example.yourdestinyweb.repositories.DungeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DungeonService {

    private final DungeonRepository dungeonRepository;


    public DungeonService(DungeonRepository dungeonRepository) {
        this.dungeonRepository = dungeonRepository;
    }

    public List<Dungeon> allDungeon() {
        List<Dungeon> dungeons = dungeonRepository.findAllDungeonsWithEncounters();
        System.out.println(dungeons.get(0).toString());
        return dungeonRepository.findAllDungeonsWithEncounters();
    }

    public ResponseEntity<Dungeon> find_Dungeon(Long id) {
        Optional<Dungeon> optionalDungeon = dungeonRepository.findById(id);

        return optionalDungeon.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveDungeon(Dungeon dungeon) {

        if (dungeon.getDungeonEncounters() != null) {
            for (DungeonEncounters encounter : dungeon.getDungeonEncounters()) {
                encounter.setDungeon(dungeon);
            }
        }

        dungeonRepository.save(dungeon);
    }

    public void deleteDungeonById(Long id) {
        dungeonRepository.deleteById(id);
    }

    public void updateDungeon(Long id, Dungeon updatedDungeon) {
        // Retrieve the existing dungeon
        Dungeon existingDungeon = dungeonRepository.findById(id).orElseThrow(() -> new RuntimeException("Dungeon not found"));

        // Update the fields with the new values
        existingDungeon.setName(updatedDungeon.getName());
        existingDungeon.setIcon(updatedDungeon.getIcon());
        existingDungeon.setPredicat(updatedDungeon.getPredicat());
        existingDungeon.setDiff(updatedDungeon.getDiff());

        // Update the DungeonEncounters
        List<DungeonEncounters> updatedEncounters = updatedDungeon.getDungeonEncounters();

        // Clear existing DungeonEncounters and set the new ones
        existingDungeon.getDungeonEncounters().clear();

        if (updatedEncounters != null) {
            for (DungeonEncounters updatedEncounter : updatedEncounters) {
                // Set the bidirectional relationship
                updatedEncounter.setDungeon(existingDungeon);
                existingDungeon.getDungeonEncounters().add(updatedEncounter);
            }
        }

        // Save the updated dungeon
        dungeonRepository.save(existingDungeon);
    }
}