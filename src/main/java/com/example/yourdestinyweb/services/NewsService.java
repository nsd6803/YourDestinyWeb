package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Armor;
import com.example.yourdestinyweb.models.News;
import com.example.yourdestinyweb.repositories.ArmorRepository;
import com.example.yourdestinyweb.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> allNews() {
        return newsRepository.findAllNews();
    }

    public ResponseEntity<News> find_News(Long id) {
        Optional<News> optionalArmor = newsRepository.findById(id);

        return optionalArmor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveNews(News news) {
        newsRepository.save(news);
    }

    public void deleteNewsById(Long id) {
        newsRepository.deleteById(id);
    }

    public void updateNews(Long id, News updateNews) {
        // Retrieve the existing armor
        News existingNews = newsRepository.findById(id).orElseThrow(() -> new RuntimeException("Armor not found"));

        // Update the fields with the new values
        existingNews.setArticle(updateNews.getArticle());
        existingNews.setDate(updateNews.getDate());
        existingNews.setLink_(updateNews.getLink_());

        // Save the updated armor
        newsRepository.save(existingNews);
    }
}
