package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.repositories.ArmorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorService {
    private final ArmorRepository armorRepository;

    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public List<Armor> allArmour() {
        return armorRepository.findAll();
    }

    public ResponseEntity<Armor> find_Armour(Long id) {
        Optional<Armor> optionalArmor = armorRepository.findById(id);

        return optionalArmor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveArmor(Armor armor) {
        armorRepository.save(armor);
    }

    public void deleteArmorById(Long id) {
        armorRepository.deleteById(id);
    }

    public void updateArmor(Long id, Armor updatedArmor) {
        // Retrieve the existing armor
        Armor existingArmor = armorRepository.findById(id).orElseThrow(() -> new RuntimeException("Armor not found"));

        // Update the fields with the new values
        existingArmor.setName(updatedArmor.getName());
        existingArmor.setIcon(updatedArmor.getIcon());
        existingArmor.setPicture(updatedArmor.getPicture());
        existingArmor.setType(updatedArmor.getType());
        existingArmor.setPredicat(updatedArmor.getPredicat());
        existingArmor.setExotic_icon(updatedArmor.getExotic_icon());
        existingArmor.setPerk_name(updatedArmor.getPerk_name());
        existingArmor.setPerk_desc(updatedArmor.getPerk_desc());
        existingArmor.setFor_class(updatedArmor.getFor_class());
        existingArmor.setLore(updatedArmor.getLore());

        // Save the updated armor
        armorRepository.save(existingArmor);
    }
}
