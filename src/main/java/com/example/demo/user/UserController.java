package com.example.demo.user;

import com.example.demo.security.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AppUserDetailsService userDetailsService;

    @GetMapping("all")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getByUserId(@PathVariable("id") Integer id){
        return userDao.findByUserId(id);
    }

    @GetMapping(value = "/getcredentials")
    public User getCredentials() {
        HttpStatus status = HttpStatus.OK;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.findByUsername(authentication.getName());
        return user;
    }
}


