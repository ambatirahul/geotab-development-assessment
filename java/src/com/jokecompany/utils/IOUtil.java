package com.jokecompany.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.jokecompany.constants.StringConstants;
import com.jokecompany.helpers.Validator;

/**
 * A utility for IO operations
 *
 */
public class IOUtil {

    private IOUtil() {
    }

    private static final ConsolePrinter CONSOLE = new ConsolePrinter();

    /**
     * Get user input.
     * 
     * @param bufferedReader {@link BufferedReader}
     * @param message
     * @return {@link String}
     * @throws IOException
     */
    public static String getUserInput(BufferedReader bufferedReader, String message) throws IOException {

        CONSOLE.Value(message).toString();
        String input = bufferedReader.readLine().toLowerCase();

        while (input == null || input.trim().isEmpty()) {

            CONSOLE.Value(StringConstants.ERROR.INVALID_INPUT + message).toString();
            input = bufferedReader.readLine();
        }

        return input;
    }

    /**
     * Get user input along with validator to validate.
     * 
     * @param bufferedReader {@link BufferedReader}
     * @param message
     * @param validator      {@link String}
     * @return {@link String}
     * @throws IOException
     */
    public static String getUserInput(BufferedReader bufferedReader, String message, String validator)
            throws IOException {

        CONSOLE.Value(message).toString();
        String input = bufferedReader.readLine().toLowerCase();

        while (input == null || input.trim().isEmpty()
                || !Validator.VALIDATORS.get(validator).contains(input.trim().charAt(0))) {

            CONSOLE.Value(StringConstants.ERROR.INVALID_INPUT + message).toString();
            input = bufferedReader.readLine();
        }

        return input;
    }

    /**
     * Print
     * 
     * @param item
     */
    public static void print(String item) {
        System.out.println("[" + item + "]");
    }

    /**
     * Print list
     * 
     * @param list
     */
    public static void printList(List<String> list) {
        System.out.println(list);
    }

    /**
     * Print exception
     * 
     * @param ex {@link Exception}
     */
    public static void printException(Exception ex) {
        System.out.println("[cause:" + ex.getCause().toString() + " message:" + ex.getMessage() + "]");
    }
}
