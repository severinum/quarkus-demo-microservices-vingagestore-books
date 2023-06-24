package com.severinu.quarkus.microservices.book;

import com.severinu.quarkus.microservices.number.NumberProxy;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;

@Slf4j
@Path("/api/books")
@Tag(name = "Book REST Endpoint")
public class BookResource {

    @RestClient
    NumberProxy numberProxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new book", description = "Book with ISBN from Numbers API")
    public Response createBook(Book bookParam) {
        Book book = new Book();
        book.setIsbn(numberProxy.generateIsbnNumbers().getIsbn13());
        book.setTitle(bookParam.getTitle());
        book.setAuthor(bookParam.getAuthor());
        book.setPublicationYear(bookParam.getPublicationYear());
        book.setCreationDate(LocalDate.now());
        book.setGenre(bookParam.getGenre());

        log.info("Creating new book: {}", book);
        return Response.status(201).entity(book).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/healthcheck")
    public String hello() {
        log.info("Health-check endpoint called");
        return "OK Books";
    }
}
