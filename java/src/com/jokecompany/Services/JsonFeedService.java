package com.jokecompany.Services;

import com.google.gson.Gson;

import static com.jokecompany.Constants.JsonFeedConsts.*;

import com.jokecompany.Helpers.UserIOHelper;
import com.jokecompany.Models.PersonModel;
import com.jokecompany.Models.JokeModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JsonFeedService implements IJsonFeedService {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private UserIOHelper userIOHelper = new UserIOHelper();

    /**
     *
     * @param firstname the first name from a random name api call, will replace the original first name
     * @param lastname the last name from a random name api call, will replase the original last name
     * @param gender gender from the random name api call, if female, pronouns will be replaced accordingly
     * @param category category from user input
     * @return
     */
    @Override
    public String getRandomJokes(String firstname, String lastname, String gender, String category) {
        String url = BASE_URL + "/random";
        if (category != null && category.length() > 0) {
            url += ("?category=") + category;
        }
        JokeModel jokeModel = null;
        try {
            URI uri = new URI(url);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            //get joke
            jokeModel = new Gson().fromJson(CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body(), JokeModel.class);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            userIOHelper.printError(e.getMessage());
        }
        //check if successfully got joke
        if (jokeModel.getValue() == null) {
            return jokeModel.getMessage();
        }
        String joke = jokeModel.getValue();
        //replace name
        if (firstname != null && lastname != null) {
            String fullName = firstname + " " + lastname;
            joke = replaceName(joke, fullName);
        }
        //replace pronoun
        if (gender!=null&&gender.equals("female")) {
            joke = replacePronoun(joke);
        }
        return joke;
    }

    /**
     *
     * @return make an api call to get person model which includes first name, last name, gender and region
     */
    @Override
    public PersonModel getRandomNames() {
        String names = null;
        try {
            URI uri = new URI(NAME_URL);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            names = CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            userIOHelper.printError(e.getMessage());
        }
        Gson gson = new Gson();
        return gson.fromJson(names, PersonModel.class);
    }


    /**
     *
     * @return make an api call to get list of categories.
     */
    @Override
    public List<String> getCategories() {
        String responseBody = null;
        try {
            URI uri = new URI(BASE_URL + "/categories");
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            responseBody = CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            userIOHelper.printError(e.getMessage());
        }
        return new Gson().fromJson(responseBody, ArrayList.class);
    }

    /**
     *
     * @param joke the original joke from api call, the original name in it will be replased.
     * @param name the new name that's replacing the original name
     * @return String of the new joke with new names in it
     */
    private String replaceName(String joke, String name) {
        int index = joke.indexOf(NAMETOREPLACE);
        while (index != -1) {
            String firstPart = joke.substring(0, index);
            String secondPart = joke.substring(index + NAMETOREPLACE.length());
            joke = firstPart + name + secondPart;
            index = joke.indexOf(NAMETOREPLACE);
        }
        return joke;
    }

    /**
     *
     * @param joke The original joke whose pronouns will be replaced if the new model is female
     * @return String of the new joke with new pronouns in it
     */
    private String replacePronoun(String joke) {
        joke = joke.replace(" he ", " she ");
        joke = joke.replace(" He ", " She ");
        joke = joke.replace(" Him ", " Her ");
        joke = joke.replace(" him ", " her ");
        joke = joke.replace(" him ", " her ");
        joke = joke.replace(" His ", " Her ");
        joke = joke.replace(" his ", " her ");
        joke = joke.replace(" Himself ", " Herself ");
        joke = joke.replace(" himself ", " herself ");
        return joke;
    }


}
