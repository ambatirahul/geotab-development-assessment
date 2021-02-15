package com.jokecompany.Services;

import com.jokecompany.Helpers.UserIOHelper;
import com.jokecompany.Models.PersonModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.jokecompany.Constants.JsonFeedConsts.*;

public class ConsoleService implements IConsoleService {

    private String oneJoke;
    private char key;
    private String fullName;
    private String firstName;
    private String lastName;
    private UserIOHelper userIOHelper = new UserIOHelper();
    private String gender;
    private List<String> categoryResult = null;

    private String selectedCategory;

    /**
     * Starts the console application, by prompting user instructions.
     *
     * @throws IOException
     */
    public void startJokeCompany() throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        userIOHelper.getUserInputAndValidate(c, "init", PROMPT_INSTRUCTION);
        while (true) {
            key = userIOHelper.getUserInputAndValidate(c, "cateOrJoke", PROMPT_CATAORJOKE).charAt(0);
            if (key == 'c') {
                getCategories();
            }
            if (key == 'r') {
                key = userIOHelper.getUserInputAndValidate(c, "yesOrNo", PROMPT_RANDOMNAME).charAt(0);
                if (key == 'y') {
                    getNames();
                }
                key = userIOHelper.getUserInputAndValidate(c, "yesOrNo", PROMPT_SPICIFYCATE).charAt(0);
                if (key == 'y') {
                    selectedCategory = userIOHelper.getUserInputAndValidate(c, PROMPT_ENTERCATE);
                }
                key = userIOHelper.getUserInputAndValidate(c, "numbers", PROMPT_NUMBEROFJOKE).charAt(0);
                int n = Character.getNumericValue(key);
                getRandomJokes(selectedCategory, n);
            }
        }
    }

    /**
     * @param category category from user input
     * @param number   how many jokes would the user like
     */
    @Override
    public void getRandomJokes(String category, int number) {
        for (int i = 0; i < number; i++) {
            if (fullName != null && !fullName.isEmpty()) {
                oneJoke = new JsonFeedService().getRandomJokes(firstName, lastName, gender, category);
            } else {
                oneJoke = new JsonFeedService().getRandomJokes(null, null, null, category);
            }
            userIOHelper.printJoke(oneJoke);
        }
    }

    /**
     * call JsonFeedService to get the list of catagories.
     */
    @Override
    public void getCategories() {
        categoryResult = new JsonFeedService().getCategories();
        userIOHelper.printCategory(categoryResult);

    }

    /**
     * Call JsonFeedService to get a random name and gender
     */
    @Override
    public void getNames() {
        PersonModel personModel = new JsonFeedService().getRandomNames();
        firstName = personModel.getName();
        lastName = personModel.getSurname();
        gender = personModel.getGender();
        fullName = (personModel.getName() + " " + personModel.getSurname());
    }
}
