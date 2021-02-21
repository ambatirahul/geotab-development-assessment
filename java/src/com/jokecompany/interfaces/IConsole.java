package com.jokecompany.interfaces;

/**
 * Console (input) interface
 *
 */
public interface IConsole {

    /**
     * Get categories
     */
    void getCategories();

    /**
     * Get names
     */
    void getNames();

    /**
     * Get some random jokes
     * 
     * @param category of joke
     * @param number   of jokes
     */
    void getRandomJokes(String category, int number);

}
