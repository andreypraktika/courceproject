package com.example.demo.photosForNews;

import com.example.demo.news.News;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "photos_for_news")
public class PhotosForNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer photoId;
    @Column
    private String photoUrl;

}
