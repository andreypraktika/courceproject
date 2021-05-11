package com.example.demo.campaign;

import com.example.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampaignDao extends JpaRepository<Campaign, Integer> {
    Campaign findByCampaignId(Integer userId);
    List<Campaign> findAll();

//    @Query("select c.user from Campaign c where c.campaignId = 1")
//    User getUserByCampaign();

}
