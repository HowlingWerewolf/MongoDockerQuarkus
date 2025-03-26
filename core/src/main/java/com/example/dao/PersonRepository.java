package com.example.dao;

import com.example.entity.Person;
import com.example.entity.Status;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheMongoRepository<Person> {

    // put your custom logic here as instance methods

    public Person findByName(final String name) {
        return find("name", name).firstResult();
    }

    public List<Person> findAlive() {
        return list("status", Status.Alive);
    }

    public void deleteLoics() {
        delete("name", "Loïc");
    }
}
