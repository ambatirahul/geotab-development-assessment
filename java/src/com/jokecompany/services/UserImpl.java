package com.jokecompany.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jokecompany.constants.StringConstants;
import com.jokecompany.interfaces.IConsole;
import com.jokecompany.interfaces.IUser;
import com.jokecompany.utils.IOUtil;

/**
 * Implementation of {@link IUser}
 *
 */
public class UserImpl implements IUser {

    private IConsole iConsole;

    public UserImpl() {

        this.iConsole = new ConsoleServiceImpl(new JsonFeedImpl());
    }

    @Override
    public void startCompany() throws IOException {

        char key;
        String selectedCategory = null;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.INSTRUCTION, StringConstants.PROMPT.TYPES.INPUT);

        while (true) {
            key = IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.JOKE_OR_CATEGORY,
                    StringConstants.PROMPT.TYPES.CATEGORY_OR_JOKE).charAt(0);

            if (key == 'c') {
                this.iConsole.getCategories();
            }

            if (key == 'r') {
                key = IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.RANDOM_NAME,
                        StringConstants.PROMPT.TYPES.YES_OR_NO).charAt(0);
                if (key == 'y') {
                    this.iConsole.getNames();
                }

                key = IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.SPECIFY_CATEGORY,
                        StringConstants.PROMPT.TYPES.YES_OR_NO).charAt(0);
                if (key == 'y') {
                    selectedCategory = IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.ENTER_CATEGORY);
                }

                key = IOUtil.getUserInput(bufferedReader, StringConstants.PROMPT.JOKE_NUMBER,
                        StringConstants.PROMPT.TYPES.NUMBERS).charAt(0);
                this.iConsole.getRandomJokes(selectedCategory, Character.getNumericValue(key));
            }
        }
    }

}
