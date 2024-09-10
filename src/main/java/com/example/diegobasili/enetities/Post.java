package com.example.diegobasili.enetities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int timeForRead;

}
