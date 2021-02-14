package com.jokecompany;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

final class JsonFeed {
    private JsonFeed() {
    }
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://api.chucknorris.io/jokes";
    private static final String NAME_URL = "https://www.names.privserv.com/api/";

    public static String[] getRandomJokes(String firstname, String lastname, String category) throws URISyntaxException, IOException, InterruptedException {
        StringBuilder url = new StringBuilder(BASE_URL + "/random");
        if (category != null && category.length() > 0) {
            url.append("?category=").append(category);
        }
        URI uri = new URI(url.toString());
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        //get joke
        JokeResponse jokeResponse = new Gson().fromJson(CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body(), JokeResponse.class);
        //check if successfully got joke
        if (jokeResponse.getValue() == null) {
            return new String[]{jokeResponse.getMessage()};
        }
        String joke = jokeResponse.getValue();
        //replace name
        if (firstname != null && lastname != null) {
            int index = joke.indexOf("Chuck Norris");
            String firstPart = joke.substring(0, index);
            String secondPart = joke.substring(index + "Chuck Norris".length());
            //get rid of the space
//            joke = firstPart + " " + firstname + " " + lastname + secondPart;
            joke = firstPart + firstname + " " + lastname + secondPart;
        }
        Gson jsonobject = new GsonBuilder().disableHtmlEscaping().create();
        return new String[]{jsonobject.toJson(joke)};
    }

    public static Dto getnames() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(NAME_URL);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        String names = CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        Gson gson = new Gson();
        return gson.fromJson(names, Dto.class);
    }

    public static String[] getCategories() throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI(BASE_URL + "/categories");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        String responseBody = CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        //used json parse to make category more readable
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(responseBody);
        return new String[] {new Gson().toJson(je)};
    }

}
