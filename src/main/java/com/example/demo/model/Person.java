package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID id;

    @NotBlank
    private final String firstName;
    private final String surname;
    private final String email;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String firstName, String surname, String email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
