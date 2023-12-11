package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.TriumphTasks;
import com.example.yourdestinyweb.models.Weapon;
import com.example.yourdestinyweb.models.WeaponStats;
import com.example.yourdestinyweb.repositories.WeaponRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public List<Weapon> allWeapon() {
        List<Weapon> weapons = weaponRepository.findAllWeapon();
        return weaponRepository.findAllWeapon();
    }

    public ResponseEntity<Weapon> find_Weapon(Long id) {
        Optional<Weapon> optionalTriumph = weaponRepository.findById(id);

        return optionalTriumph.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveWeapon(Weapon weapon) {

        if (weapon.getWeaponStats() != null) {
            for (WeaponStats stats : weapon.getWeaponStats()) {
                stats.setWeapon(weapon);
            }
        }

        weaponRepository.save(weapon);
    }

    public void deleteWeaponById(Long id) {
        weaponRepository.deleteById(id);
    }

    public void updateWeapon(Long id, Weapon updatedWeapon) {
        // Retrieve the existing dungeon
        Weapon existingWeapon = weaponRepository.findById(id).orElseThrow(() -> new RuntimeException("Triumph not found"));

        // Update the fields with the new values
        existingWeapon.setName(updatedWeapon.getName());
        existingWeapon.setIcon(updatedWeapon.getIcon());
        existingWeapon.setPicture(updatedWeapon.getPicture());
        existingWeapon.setType(updatedWeapon.getType());
        existingWeapon.setElement(updatedWeapon.getElement());
        existingWeapon.setPredicat(updatedWeapon.getPredicat());
        existingWeapon.setIsExotic(updatedWeapon.getIsExotic());
        existingWeapon.setExoticIcon(updatedWeapon.getExoticIcon());
        existingWeapon.setPerkName(updatedWeapon.getPerkName());
        existingWeapon.setPerkDesc(updatedWeapon.getPerkDesc());
        existingWeapon.setLore(updatedWeapon.getLore());


        // Update the DungeonEncounters
        List<WeaponStats> updatedStats = updatedWeapon.getWeaponStats();

        // existingRaid existing DungeonEncounters and set the new ones
        existingWeapon.getWeaponStats().clear();

        if (updatedStats != null) {
            for (WeaponStats updatedStat : updatedStats) {
                // Set the bidirectional relationship
                updatedStat.setWeapon(existingWeapon);
                existingWeapon.getWeaponStats().add(updatedStat);
            }
        }

        // Save the updated dungeon
        weaponRepository.save(existingWeapon);
    }
}
