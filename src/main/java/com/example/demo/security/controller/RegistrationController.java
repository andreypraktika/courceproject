package com.example.demo.security.controller;

import com.example.demo.user.User;
import com.example.demo.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    @PostMapping("/register")
    public void save(@RequestBody User user){
        user.setRole("User");
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

}
