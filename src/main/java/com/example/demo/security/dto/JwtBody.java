package com.example.demo.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtBody {
    private String username;
    private String password;
}
