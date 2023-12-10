package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.Raid;
import com.example.yourdestinyweb.models.Triumph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TriumphRepository extends JpaRepository<Triumph, Long> {
    @Query("SELECT d FROM Triumph d LEFT JOIN FETCH d.triumphTasks de")
    List<Triumph> findAllTriumph();
}