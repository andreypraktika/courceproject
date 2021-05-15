package com.example.demo.photosForNews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhotosForNewsDao extends JpaRepository<PhotosForNews,Integer> {
    @Override
    List<PhotosForNews> findAll();
}
