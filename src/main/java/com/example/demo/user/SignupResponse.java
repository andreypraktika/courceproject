package com.example.demo.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupResponse {
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
}
