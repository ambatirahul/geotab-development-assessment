package com.jokecompany;

import com.jokecompany.Helpers.UserIOHelper;
import com.jokecompany.Services.ConsoleService;
import com.jokecompany.Services.IConsoleService;
import com.jokecompany.Services.IJsonFeedService;
import com.jokecompany.Services.JsonFeedService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jokecompany.Constants.JsonFeedConsts.*;
import static com.jokecompany.Constants.JsonFeedConsts.PROMPT_NUMBEROFJOKE;

public class UserInterface {

    private char key;

    private String selectedCategory;

    private JsonFeedService jsonFeedService;

    //call the interface
    private IConsoleService consoleService = new ConsoleService(new JsonFeedService());

    /**
     * Starts the console application, by prompting user instructions.
     *
     * @throws IOException
     */
    public void startJokeCompany() throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        UserIOHelper.getUserInputAndValidate(c, "init", PROMPT_INSTRUCTION);
        while (true) {
            key = UserIOHelper.getUserInputAndValidate(c, "cateOrJoke", PROMPT_CATAORJOKE).charAt(0);
            if (key == 'c') {
                consoleService.getCategories();
            }
            if (key == 'r') {
                key = UserIOHelper.getUserInputAndValidate(c, "yesOrNo", PROMPT_RANDOMNAME).charAt(0);
                if (key == 'y') {
                    consoleService.getNames();
                }
                key = UserIOHelper.getUserInputAndValidate(c, "yesOrNo", PROMPT_SPICIFYCATE).charAt(0);
                if (key == 'y') {
                    selectedCategory = UserIOHelper.getUserInputAndValidate(c, PROMPT_ENTERCATE);
                }
                key = UserIOHelper.getUserInputAndValidate(c, "numbers", PROMPT_NUMBEROFJOKE).charAt(0);
                int n = Character.getNumericValue(key);
                consoleService.getRandomJokes(selectedCategory, n);
            }
        }
    }
}
