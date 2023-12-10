package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.repositories.RaidRepository;
import com.example.yourdestinyweb.repositories.TriumphRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriumphService {

    private final TriumphRepository raidRepository;


    public TriumphService(TriumphRepository raidRepository) {
        this.raidRepository = raidRepository;
    }

    public List<Triumph> allTriumph() {
        List<Triumph> raids = raidRepository.findAllTriumph();
        return raidRepository.findAllTriumph();
    }
}