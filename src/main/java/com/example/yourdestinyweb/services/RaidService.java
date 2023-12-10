package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
