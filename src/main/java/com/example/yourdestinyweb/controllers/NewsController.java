package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Dungeon;
import com.example.yourdestinyweb.models.News;
import com.example.yourdestinyweb.services.DungeonService;
import com.example.yourdestinyweb.services.NewsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Новости", description = "вся информация о новостях")
@RestController
@SecurityRequirement(name = "JWT")
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<News>> allDungeon() {
        List<News> news = newsService.allNews();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> news(Model model, @PathVariable Long id) {
        News news = newsService.find_News(id).getBody();

        if (news != null) {
            return ResponseEntity.ok(news);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<News> add_Dungeon(@RequestBody News news) {
        try {
            newsService.saveNews(news);
            return ResponseEntity.ok(news);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        try {
            newsService.deleteNewsById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Void> updateDungeon(@PathVariable Long id, @RequestBody News updatedNews) {
        try {
            newsService.updateNews(id, updatedNews);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}