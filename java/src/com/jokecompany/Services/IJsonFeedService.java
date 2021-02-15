package com.jokecompany.Services;

import com.jokecompany.Models.PersonModel;

import java.util.List;

public interface IJsonFeedService {
    String getRandomJokes(String firstname, String lastname, String gender, String category);

    PersonModel getRandomNames();

    List<String> getCategories();
}
