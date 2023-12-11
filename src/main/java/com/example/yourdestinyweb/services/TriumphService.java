package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.RaidEncounters;
import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.TriumphTasks;
import com.example.yourdestinyweb.repositories.RaidRepository;
import com.example.yourdestinyweb.repositories.TriumphRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TriumphService {

    private final TriumphRepository triumphRepository;


    public TriumphService(TriumphRepository raidRepository) {
        this.triumphRepository = raidRepository;
    }

    public List<Triumph> allTriumph() {
        List<Triumph> triumph = triumphRepository.findAllTriumph();
        return triumphRepository.findAllTriumph();
    }

    public ResponseEntity<Triumph> find_Triumph(Long id) {
        Optional<Triumph> optionalTriumph = triumphRepository.findById(id);

        return optionalTriumph.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveTriumph(Triumph triumph) {

        if (triumph.getTriumphTasks() != null) {
            for (TriumphTasks tasks : triumph.getTriumphTasks()) {
                tasks.setTriumph(triumph);
            }
        }

        triumphRepository.save(triumph);
    }

    public void deleteTriumphById(Long id) {
        triumphRepository.deleteById(id);
    }

    public void updateTriumph(Long id, Triumph updatedTriumph) {
        // Retrieve the existing dungeon
        Triumph existingTriumph = triumphRepository.findById(id).orElseThrow(() -> new RuntimeException("Triumph not found"));

        // Update the fields with the new values
        existingTriumph.setName(updatedTriumph.getName());
        existingTriumph.setIcon(updatedTriumph.getIcon());


        // Update the DungeonEncounters
        List<TriumphTasks> updatedTasks = updatedTriumph.getTriumphTasks();

        // existingRaid existing DungeonEncounters and set the new ones
        existingTriumph.getTriumphTasks().clear();

        if (updatedTasks != null) {
            for (TriumphTasks updatedTask : updatedTasks) {
                // Set the bidirectional relationship
                updatedTask.setTriumph(existingTriumph);
                existingTriumph.getTriumphTasks().add(updatedTask);
            }
        }

        // Save the updated dungeon
        triumphRepository.save(existingTriumph);
    }
}