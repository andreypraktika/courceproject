package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);
    List<User> findAll();
    User findByUsername(String name);
}