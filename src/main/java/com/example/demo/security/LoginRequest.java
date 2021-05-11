package com.example.demo.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String pw;

    public String getPw() {
        return pw;
    }

    public String getUserName() {
        return userName;
    }
}
