package com.jokecompany.helpers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.jokecompany.constants.StringConstants;

/**
 * Class holding validations
 *
 */
public final class Validator {

    public static HashMap<String, List<Character>> VALIDATORS = new HashMap<>();

    /**
     * holds the validations
     */
    static {
        VALIDATORS.put(StringConstants.PROMPT.TYPES.INPUT, Arrays.asList('?'));
        VALIDATORS.put(StringConstants.PROMPT.TYPES.CATEGORY_OR_JOKE, Arrays.asList('c', 'r', 'C', 'R'));
        VALIDATORS.put(StringConstants.PROMPT.TYPES.YES_OR_NO, Arrays.asList('y', 'Y', 'n', 'N'));
        VALIDATORS.put(StringConstants.PROMPT.TYPES.NUMBERS,
                Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    }

}
