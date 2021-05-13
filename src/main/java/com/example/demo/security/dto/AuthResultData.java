package com.example.demo.security.dto;

import lombok.Getter;

@Getter
public class AuthResultData {
    private final String message;

    public AuthResultData(String message) {
        this.message = message;
    }


    public AuthResultData() {
        this.message="ok";
    }
}
