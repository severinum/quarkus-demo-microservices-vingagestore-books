package com.severinu.quarkus.microservices;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testHealthCheckEndpoint() {
        given()
          .when().get("/api/books/healthcheck")
          .then()
             .statusCode(200)
             .body(is("OK Books"));
    }

}