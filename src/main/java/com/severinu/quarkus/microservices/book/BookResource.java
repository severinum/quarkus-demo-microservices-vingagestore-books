package com.severinu.quarkus.microservices.book;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/api/books")
public class BookResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBook(Book bookParam) {
        log.info("Creating new book: {}", bookParam);
        Book book = new Book();
        book.setIsbn("Get from Number API");
        book.setTitle(bookParam.getTitle());
        book.setAuthor(bookParam.getAuthor());
        book.setYear(bookParam.getYear());
        book.setGenre(bookParam.getGenre());

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
