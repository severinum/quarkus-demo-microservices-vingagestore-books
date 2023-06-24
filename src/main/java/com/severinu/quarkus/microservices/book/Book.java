package com.severinu.quarkus.microservices.book;


import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Schema(description = "A book")
public class Book {

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn;

    @Schema(required = true)
    private String title;

    private String author;

    @JsonbProperty("publication_year")
    public int publicationYear;

    @JsonbProperty("creation_date")
    @JsonbDateFormat("yyyy-MM-dd")
    @Schema(implementation = String.class, format = "date")
    private LocalDate creationDate;

    private String genre;

}
