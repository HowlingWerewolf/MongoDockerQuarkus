package com.example.endpoints.person;

import com.example.dao.PersonRepository;
import com.example.entity.Person;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.net.URI;
import java.util.List;

@Path("/persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> list() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Person get(final String id) {
        return personRepository.findById(new ObjectId(id));
    }

    @POST
    public Response create(final Person person) {
        personRepository.persist(person);
        return Response.created(URI.create("/persons/" + person.id)).build();
    }

    @PUT
    @Path("/{id}")
    public void update(final String id, final Person person) {
        person.setId(new ObjectId(id));
        personRepository.update(person);
    }

    @DELETE
    @Path("/{id}")
    public void delete(final String id) {
        final Person person = personRepository.findById(new ObjectId(id));
        if (person == null) {
            throw new NotFoundException();
        }
        personRepository.delete(person);
    }

    @GET
    @Path("/search/{name}")
    public Person search(final String name) {
        return personRepository.findByName(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return personRepository.count();
    }
}
