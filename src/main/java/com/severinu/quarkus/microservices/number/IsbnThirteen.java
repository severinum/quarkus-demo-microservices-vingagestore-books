package com.severinu.quarkus.microservices.number;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IsbnThirteen {
    @JsonbProperty("isbn_13")
    public String isbn13;
}
