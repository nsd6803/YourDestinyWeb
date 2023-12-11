package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.DungeonEncounters;
import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.RaidEncounters;
import com.example.yourdestinyweb.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaidService {

    private final RaidRepository raidRepository;


    public RaidService(RaidRepository raidRepository) {
        this.raidRepository = raidRepository;
    }

    public List<Raid> allRaid() {
        List<Raid> raids = raidRepository.findAllRaidsWithEncounters();
        return raidRepository.findAllRaidsWithEncounters();
    }

    public ResponseEntity<Raid> find_Raid(Long id) {
        Optional<Raid> optionalRaid = raidRepository.findById(id);

        return optionalRaid.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveRaid(Raid raid) {

        if (raid.getRaidEncounters() != null) {
            for (RaidEncounters encounter : raid.getRaidEncounters()) {
                encounter.setRaid(raid);
            }
        }

        raidRepository.save(raid);
    }

    public void deleteRaidById(Long id) {
        raidRepository.deleteById(id);
    }

    public void updateRaid(Long id, Raid updatedRaid) {
        // Retrieve the existing dungeon
        Raid existingRaid = raidRepository.findById(id).orElseThrow(() -> new RuntimeException("Dungeon not found"));

        // Update the fields with the new values
        existingRaid.setName(updatedRaid.getName());
        existingRaid.setIcon(updatedRaid.getIcon());
        existingRaid.setPredicat(updatedRaid.getPredicat());
        existingRaid.setDiff(updatedRaid.getDiff());

        // Update the DungeonEncounters
        List<RaidEncounters> updatedEncounters = updatedRaid.getRaidEncounters();

        // existingRaid existing DungeonEncounters and set the new ones
        existingRaid.getRaidEncounters().clear();

        if (updatedEncounters != null) {
            for (RaidEncounters updatedEncounter : updatedEncounters) {
                // Set the bidirectional relationship
                updatedEncounter.setRaid(existingRaid);
                existingRaid.getRaidEncounters().add(updatedEncounter);
            }
        }

        // Save the updated dungeon
        raidRepository.save(existingRaid);
    }
}
