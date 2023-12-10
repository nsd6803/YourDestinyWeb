package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaidRepository extends JpaRepository<Raid, Long> {
    @Query("SELECT d FROM Raid d LEFT JOIN FETCH d.raidEncounters de")
    List<Raid> findAllRaidsWithEncounters();
}
