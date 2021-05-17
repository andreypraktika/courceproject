package com.example.demo.campaign;

import com.example.demo.news.News;
import com.example.demo.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@NoArgsConstructor
@Table(name = "Campaigns")
@Getter
@Setter
@AllArgsConstructor
public class    Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "campaign_id")
    private Integer campaignId;
    @Column(name = "campaignname")
    private String campaignName;
    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date utilTimestamp;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "campaign_id")
    private List<News> news;



    //    @Column(name = "tags")
//    private List<String> tags;
//    @Column(name = "news")
//    private List<String> news;
//    @Column(name = "images")
//    private List<String> images;
//    @Column(name = "bonuses")
//    private List<String> bonuses;
//    @Column(name = "bonuses")
//    private Integer bonuses;
}






//@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);