package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.DungeonEncounters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DungeonRepository extends JpaRepository<Dungeon, Long> {
    @Query("SELECT d FROM Dungeon d LEFT JOIN FETCH d.dungeonEncounters de")
    List<Dungeon> findAllDungeonsWithEncounters();
}
