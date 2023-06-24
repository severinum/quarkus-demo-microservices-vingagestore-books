package com.severinu.quarkus.microservices.book;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private String genre;

}
