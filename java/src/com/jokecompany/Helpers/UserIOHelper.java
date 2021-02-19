package com.jokecompany.Helpers;

import com.jokecompany.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static com.jokecompany.Constants.JsonFeedConsts.*;

public final class UserIOHelper {
    //instantiation now allowed
    private UserIOHelper() {}

    private static final PrinterHelper PRINTER = new PrinterHelper();
    private static HashMap<String, List<Character>> validators = new HashMap<>();

    static{
//        HashMap<String, List<Character>> validators = new HashMap<>();
        validators.put("init", Arrays.asList('?'));
        validators.put("cateOrJoke", Arrays.asList('c','r', 'C','R'));
        validators.put("yesOrNo", Arrays.asList('y','Y','n','N'));
        validators.put("numbers", Arrays.asList('1','2','3','4','5','6','7','8','9'));
    }


    /**
     *
     * @param in BufferReader passed by ConsoleService.class for user input
     * @param message message that's going to prompt to user
     * @return
     * @throws IOException
     */
    public static String getUserInputAndValidate(BufferedReader in, String message) throws IOException {
        PRINTER.Value(message).toString();
        String input = in.readLine().toLowerCase(Locale.ROOT);
        while (input==null||input.trim().isEmpty()) {
            PRINTER.Value(ERROR_INVALID_INPUT + message).toString();
            input = in.readLine();
        }
        return input;
    }

    /**
     *
     * @param in BufferReader passed by ConsoleService.class for user input
     * @param validator current validator
     * @param message message that's going to prompt to user
     * @return
     * @throws IOException
     */
    public static String getUserInputAndValidate(BufferedReader in, String validator, String message) throws IOException {


        PRINTER.Value(message).toString();
        String input = in.readLine().toLowerCase(Locale.ROOT);
        //added input empty validation
        while (input.isEmpty()||!validators.get(validator).contains(input.trim().charAt(0))) {
            PRINTER.Value(ERROR_INVALID_INPUT + message).toString();
            input = in.readLine();
        }
        return input;
    }

    /**
     *
     * @param categories list of categories returned from api call
     */
    public static void printCategory(List<String> categories) {
        System.out.println(categories);
    }

    /**
     *
     * @param joke String of 1 joke from api call
     */
    public static void printJoke(String joke) {
        System.out.println("[" + joke+ "]");

    }

    /**
     *
     * @param exception error message from exception
     */
    public static void printError(String exception) {
        System.out.println(exception);
    }

}
