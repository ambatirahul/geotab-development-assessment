package com.jokecompany.constants;

import java.util.Arrays;

/**
 * Place holder for constants
 *
 */
public final class StringConstants {

    // api, urls
    public static class URL {
        public static final String BASE = "https://api.chucknorris.io/jokes";
        public static final String NAMES_API = "https://www.names.privserv.com/api/";

        public static class PATHPARAMS {
            public static final String CATEGORIES = "/categories";
            public static final String RANDOM = "/random";
        }

        public static class QUERYPARAMS {
            public static final String CATEGORY = "?category=";
        }
    }

    // error messages
    public static class ERROR {
        public static final String INVALID_INPUT = "Invalid input.\n";
        public static final String INVALID_CATEGORY = "Invalid category: ";
        public static final String RETRIEVING_CATEGORIES = "Error retrieving categories.\n";
        public static final String RETRIEVING_NAMES = "Error retrieving names.\n";
        public static final String RETRIEVING_JOKES = "Error retrieving jokes.\n";
        public static final String WRONG_CATEGORY = "Wrong category named.\n";
    }

    // prompts messages
    public static class PROMPT {
        public static final String CATEGORY = "Press c to get categories";
        public static final String ENTER_CATEGORY = "Enter a category.";
        public static final String INSTRUCTION = "Press ? to get instructions.";
        public static final String JOKE_OR_CATEGORY = "Press c to get categories or r to get random jokes";
        public static final String JOKE_NUMBER = "How many jokes do you want? (1-9)";
        public static final String RANDOM_JOKE = "Press r to get random jokes";
        public static final String RANDOM_NAME = "Want to use random name? y/n";
        public static final String SPECIFY_CATEGORY = "Want to specify a category? y/n";

        public static class TYPES {
            public static final String INPUT = "input";
            public static final String CATEGORY_OR_JOKE = "categoryOrJoke";
            public static final String YES_OR_NO = "yesOrNo";
            public static final String NUMBERS = "numbers";
        }
    }

    // Additional strings
    public static class ADDITIONAL {
        public static final String REPLACE = "Chuck Norris";
    }

}
