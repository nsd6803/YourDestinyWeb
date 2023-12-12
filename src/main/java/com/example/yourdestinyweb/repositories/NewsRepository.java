package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.News;
import com.example.yourdestinyweb.models.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT n FROM News n ORDER BY n.date DESC")
    List<News> findAllNews();
}