package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.repositories.ArmorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorService {
    private final ArmorRepository armorRepository;

    @Autowired
    public ArmorService(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    public List<Armor> allArmour() {
        return armorRepository.findAll();
    }
}
