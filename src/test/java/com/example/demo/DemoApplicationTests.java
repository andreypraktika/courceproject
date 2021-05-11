package com.example.demo;

import com.example.demo.campaign.Campaign;
import com.example.demo.campaign.CampaignDao;
import com.example.demo.news.News;
import com.example.demo.news.NewsDao;
import com.example.demo.user.User;
import com.example.demo.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CampaignDao cDao;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	public void showAllUsers() throws Exception {
		List<User> list = userDao.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	public void showAllNews() throws Exception{
		List<News> list = newsDao.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	public void showAllCampaigns() throws Exception {
		List<Campaign> campaignList = cDao.findAll();
		System.out.println(campaignList);
	}

	@Test
	public void getUserById() throws Exception {
		User user = userDao.findByUserId(1);
		System.out.println(user);
	}

	@Test
	public void getUserByUsername() throws Exception {
		System.out.println();
	}


}
