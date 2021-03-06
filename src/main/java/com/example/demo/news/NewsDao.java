package com.example.demo.news;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsDao extends JpaRepository<News, Integer> {
    @Override
    List<News> findAll();
}
