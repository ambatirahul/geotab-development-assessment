package com.jokecompany.Models;

/**
 * person variables generated from api call
 */
public class PersonModel {
    private String name;
    private String surname;
    private String gender;
    private String region;

    public PersonModel(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }
}
