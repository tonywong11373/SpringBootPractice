package com.example.demo.dao;

import java.util.UUID;

// For the benefits of using Interface to allow Dependency Injection for the sake of 
// conducting an Unit Testing Automated
public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    // We have two methods, one allow insert person with id, one without id in which the id would be randomly generated
}
