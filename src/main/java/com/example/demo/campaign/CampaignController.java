package com.example.demo.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("campaigns")
@CrossOrigin(origins = "*")
public class CampaignController {

    @Autowired
    private CampaignDao campaignDao;

    @GetMapping("all")
    public List<Campaign> getAllCampaigns(){
        return campaignDao.findAll();
    }
}
