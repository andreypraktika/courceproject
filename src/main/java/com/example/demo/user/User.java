package com.example.demo.user;

import com.example.demo.campaign.Campaign;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "email")
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name = "role")
    private String role;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Campaign> campaigns;

    public User(String username, String password, Boolean enabled, String email, String role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User {" +
                "username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
