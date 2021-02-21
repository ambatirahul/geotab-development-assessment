package com.jokecompany.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.jokecompany.constants.StringConstants;
import com.jokecompany.interfaces.IJsonFeed;
import com.jokecompany.models.Joke;
import com.jokecompany.models.Person;
import com.jokecompany.utils.HttpUtil;
import com.jokecompany.utils.IOUtil;

/**
 * Implementation of {@link IJsonFeed}
 *
 */
public class JsonFeedImpl implements IJsonFeed {

    private static final String FEMALE = "female";

    @Override
    public String getRandomJokes(String firstname, String lastname, String gender, String category) {

        String url = StringConstants.URL.BASE + StringConstants.URL.PATHPARAMS.RANDOM;

        if (category != null && !category.isEmpty()) {
            url += StringConstants.URL.QUERYPARAMS.CATEGORY + category;
        }

        Joke joke = null;
        try {
            String response = HttpUtil.sendRequest(HttpUtil.buildRequest(url));
            Gson gson = new Gson();
            joke = gson.fromJson(response, Joke.class);
        } catch (Exception ex) {
            IOUtil.printException(ex);
        }

        String jokeValue = joke.getValue();
        // replace name
        if (firstname != null && lastname != null) {
            String fullName = firstname + " " + lastname;
            jokeValue = replaceName(jokeValue, fullName);
        }
        // replace pronoun
        if (FEMALE.equals(gender)) {
            jokeValue = replacePronoun(jokeValue);
        }
        return jokeValue;
    }

    /**
     * Replace name
     * 
     * @param joke in which name to be replace
     * @param name to replace
     * @return replaced joke
     */
    private String replaceName(String joke, String name) {
        int index = joke.indexOf(StringConstants.ADDITIONAL.REPLACE);
        while (index != -1) {
            String firstPart = joke.substring(0, index);
            String secondPart = joke.substring(index + StringConstants.ADDITIONAL.REPLACE.length());
            joke = firstPart + name + secondPart;
            index = joke.indexOf(StringConstants.ADDITIONAL.REPLACE);
        }
        return joke;
    }

    /**
     * Replace pronoun
     * 
     * @param joke in which pronoun to replace
     * @return replaced joke
     */
    private String replacePronoun(String joke) {
        joke = joke.replace(" he ", " she ");
        joke = joke.replace(" He ", " She ");
        joke = joke.replace(" him ", " her ");
        joke = joke.replace(" Him ", " Her ");
        joke = joke.replace(" his ", " her ");
        joke = joke.replace(" His ", " Her ");
        joke = joke.replace(" himself ", " herself ");
        joke = joke.replace(" Himself ", " Herself ");
        return joke;
    }

    @Override
    public Person getRandomPerson() {

        String names = null;
        try {
            names = HttpUtil.sendRequest(HttpUtil.buildRequest(StringConstants.URL.NAMES_API));
        } catch (Exception ex) {
            IOUtil.printException(ex);
        }
        Gson gson = new Gson();
        return gson.fromJson(names, Person.class);
    }

    @Override
    public List<String> getCategories() {

        String responseBody = null;
        try {
            responseBody = HttpUtil.sendRequest(
                    HttpUtil.buildRequest(StringConstants.URL.BASE + StringConstants.URL.PATHPARAMS.CATEGORIES));
        } catch (Exception ex) {
            IOUtil.printException(ex);
        }
        Gson gson = new Gson();
        return gson.fromJson(responseBody, ArrayList.class);
    }

}
