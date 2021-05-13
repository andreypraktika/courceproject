package com.example.demo.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("news")
@CrossOrigin
public class NewsController {

    @Autowired
    private NewsDao newsDao;

    @GetMapping("/all")
    public List<News> getAllNews(){
        return newsDao.findAll();
    }

}
