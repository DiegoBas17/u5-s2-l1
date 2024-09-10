package com.example.diegobasili.enetities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateofBirth;
    private String avatar;
}
