package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    // This is the declaration of the properties of the class for the intialisation purpose
    private final UUID id;
    private final String Name;

    // Using the constructor to make the Person Method to be usable
    // Constructor is a special method to assign default values to the method
    // Take this example for illustration, there are two variables in the context
    // id and Name
    // and we are going to initialize the variables once the computer allocate resources
    // to the projects, we set the id of type UUID with the id parameter, 
    // and the Name of type String with the Name parameter.
    public Person(@JsonProperty("id")  UUID id,@JsonProperty("name") String Name)
    {
        this.id = id;
        this.Name = Name;
    }

    // The below are the methods part that we could be used to call the things
    public UUID getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
