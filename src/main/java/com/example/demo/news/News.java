package com.example.demo.news;

import com.example.demo.campaign.Campaign;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "News")
@NoArgsConstructor
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer newsId;
    @Column(name = "newstitle")
    private String newstitle;
    @Column(name = "newstext")
    private String newstext;
    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date utilTimestamp;



    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newstitle='" + newstitle + '\'' +
                ", newstext='" + newstext + '\'' +
                ", utilTimestamp=" + utilTimestamp +
                '}';
    }

    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "campaign_id")
//    private List<Campaign> campaigns;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private List<User> users;
}
