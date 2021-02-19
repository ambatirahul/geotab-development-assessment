package com.jokecompany.Services;

import com.jokecompany.Helpers.UserIOHelper;
import com.jokecompany.Models.PersonModel;


import java.util.List;

import static com.jokecompany.Constants.JsonFeedConsts.*;

public class ConsoleService implements IConsoleService {

    private String oneJoke;
    private String fullName;
    private String firstName;
    private String lastName;
    private String gender;
    private List<String> categoryResult = null;

    //call the interface
//    private IJsonFeedService jsonFeedService = new JsonFeedService();
    private IJsonFeedService jsonFeedService;

    public ConsoleService(IJsonFeedService jsonFeedService) {
        this.jsonFeedService = jsonFeedService;
    }




    /**
     * @param category category from user input
     * @param number   how many jokes would the user like
     */
    @Override
    public void getRandomJokes(String category, int number) {
        //if we have category cached but category is not in the list
        if (categoryResult == null || categoryResult.isEmpty()) {
            //note here categories will be print out again, can be fixed by passing another params but worth it?
            System.out.println("if got category before, this message won't appear");
            getCategories();
        }
        if (categoryResult.contains(category)||category==null) {

            for (int i = 0; i < number; i++) {
                if (fullName != null && !fullName.isEmpty()) {
//                    oneJoke = new JsonFeedService().getRandomJokes(firstName, lastName, gender, category);
                    oneJoke = jsonFeedService.getRandomJokes(firstName, lastName, gender, category);
                } else {
//                    oneJoke = new JsonFeedService().getRandomJokes(null, null, null, category);
                    oneJoke = jsonFeedService.getRandomJokes(null, null, null, category);
                }
                UserIOHelper.printJoke(oneJoke);
            }
        } else {
            UserIOHelper.printError(ERROR_INVALID_CATEGORY + category);
        }
    }

    /**
     * call JsonFeedService to get the list of catagories.
     */
    @Override
    public void getCategories() {
        //read the cached category data if exsits
        if(categoryResult==null) {
//            categoryResult = new JsonFeedService().getCategories();
            categoryResult = jsonFeedService.getCategories();
        }
        UserIOHelper.printCategory(categoryResult);

    }

    /**
     * Call JsonFeedService to get a random name and gender
     */
    @Override
    public void getNames() {
//        PersonModel personModel = new JsonFeedService().getRandomNames();
        PersonModel personModel = jsonFeedService.getRandomNames();
        firstName = personModel.getName();
        lastName = personModel.getSurname();
        gender = personModel.getGender();
        fullName = (personModel.getName() + " " + personModel.getSurname());
    }
}
