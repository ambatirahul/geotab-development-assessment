package com.jokecompany.interfaces;

import java.util.List;

import com.jokecompany.models.Person;

/**
 * Interface to get json feed from api's
 *
 */
public interface IJsonFeed {

    /**
     * Get random jokes
     * 
     * @param firstname
     * @param lastname
     * @param gender
     * @param category
     * @return random jokes
     */
    String getRandomJokes(String firstname, String lastname, String gender, String category);

    /**
     * Retrieve random person
     * 
     * @return {@link Person}
     */
    Person getRandomPerson();

    /**
     * Retrieve categories
     * 
     * @return categories
     */
    List<String> getCategories();

}
