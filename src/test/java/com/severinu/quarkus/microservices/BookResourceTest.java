package com.severinu.quarkus.microservices;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void should_createABook() {

        String requestBody = """
        {
            "title": "Book 01",
            "author": "John Doe",
            "genre": "IT",
            "publication_year": 1980
        }""";


        Response response = given()
                    .header("Content-type", "application/json")
                    .and().body(requestBody)
                .when().post("/api/books")
                .then()
                    .extract().response();

        assertEquals(201, response.statusCode());
        assertEquals("Book 01", response.jsonPath().getString("title"));
        assertEquals("John Doe", response.jsonPath().getString("author"));
        assertEquals("IT", response.jsonPath().getString("genre"));
        assertEquals("1980", response.jsonPath().getString("publication_year"));
        assertEquals(LocalDate.now().toString(), response.jsonPath().getString("creation_date"));
    }

}