package com.example.endpoints;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/myhello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String myhello() {
        return "Hello from Ati";
    }
}
