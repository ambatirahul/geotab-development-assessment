package com.jokecompany.services;

import java.util.List;

import com.jokecompany.constants.StringConstants;
import com.jokecompany.interfaces.IConsole;
import com.jokecompany.interfaces.IJsonFeed;
import com.jokecompany.models.Person;
import com.jokecompany.utils.IOUtil;

/**
 * Console implementation of {@link IConsole}
 * 
 */
public class ConsoleServiceImpl implements IConsole {

    private String joke;
    private String fullName;
    private String firstName;
    private String lastName;
    private String gender;
    private List<String> categories;

    private IJsonFeed jsonFeed;

    /**
     * Public constructor
     * 
     * @param jsonFeed {@link IJsonFeed}
     */
    public ConsoleServiceImpl(IJsonFeed jsonFeed) {
        this.jsonFeed = jsonFeed;
    }

    @Override
    public void getCategories() {
        if (this.categories == null) {
            this.categories = this.jsonFeed.getCategories();
        }
        IOUtil.printList(this.categories);
    }

    @Override
    public void getNames() {
        Person person = this.jsonFeed.getRandomPerson();
        this.firstName = person.getName();
        this.lastName = person.getSurname();
        this.fullName = person.getName() + " " + person.getSurname();
    }

    @Override
    public void getRandomJokes(String category, int number) {

        if (this.categories == null || this.categories.isEmpty()) {
            this.getCategories();
        }

        if (this.categories.contains(category) || category == null) {

            int i = 0;
            while (i++ < number) {
                if (this.fullName != null && !this.fullName.isEmpty()) {
                    this.joke = this.jsonFeed.getRandomJokes(this.firstName, this.lastName, this.gender, category);
                } else {
                    this.joke = this.jsonFeed.getRandomJokes(null, null, null, category);
                }
                IOUtil.print(this.joke);
            }

        } else {
            IOUtil.print(StringConstants.ERROR.INVALID_CATEGORY + category);
        }
    }

}
