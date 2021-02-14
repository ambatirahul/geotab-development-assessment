package com.jokecompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    static String[] results = new String[50];
    static char key;
    static Hashtable<String, String> names = new Hashtable<>();
    static ConsolePrinter printer = new ConsolePrinter();
    //added String category
    static String category = null;

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        getUserInputAndValidate(c, Arrays.asList("?"),"Press ? to get instructions.");
        while (true) {
            key = getUserInputAndValidate(c, Arrays.asList("c","r"),"Press c to get categories, or r to get random jokes").charAt(0);
            if (key == 'c') {
                getCategories();
                printResults();
            }
            if (key == 'r') {
                key = getUserInputAndValidate(c, Arrays.asList("y","n"),"Want to use a random name? y/n").charAt(0);
                if (key == 'y') {
                    getNames();
                } else {
//                        names = new Hashtable<>();
                    String firstName, lastName;
                    firstName = lastName = null;

                    while (firstName == null || firstName.isEmpty()) {
                        printer.Value("What's your first name?").toString();
                        firstName = c.readLine();
                    }
                    while (lastName == null || lastName.isEmpty()) {
                        printer.Value("What's your last name?").toString();
                        lastName = c.readLine();
                    }
                    names.put(firstName, lastName);
                }

                key = getUserInputAndValidate(c, Arrays.asList("y","n"),"Want to specify a category? y/n").charAt(0);
                if (key == 'y') {
                    printer.Value("Enter a category;").toString();
                    category = c.readLine();
                }

                key = getUserInputAndValidate(c, Arrays.asList("1","2","3","4","5","6","7","8","9"),"How many jokes do you want? (1-9)").charAt(0);
                int n = Integer.parseInt(String.valueOf(key));
                for (int i = 0; i < n; i++) {
                    getRandomJokes(category, n);
                    printResults();
                }
            }
            names.clear();

        }

    }

    private static String getUserInputAndValidate(BufferedReader in, List<String> list, String message) throws IOException {
        printer.Value(message).toString();
        String input = in.readLine();
        while (!list.contains(input)) {
            printer.Value("Invalid input. "+message).toString();
            input=in.readLine();
        }
        return input;
    }

    private static void printResults() {
        printer.Value("[" + String.join(",", results) + "]").toString();
    }


    private static void getRandomJokes(String category, int number) throws InterruptedException, IOException, URISyntaxException {
        if (names != null && !names.isEmpty()) {
            var var1 = names.entrySet().iterator().next();
            results = JsonFeed.getRandomJokes(var1.getKey(), var1.getValue(), category);
        } else {
            results = JsonFeed.getRandomJokes(null, null, category);
        }


    }

    private static void getCategories() throws InterruptedException, IOException, URISyntaxException {
        results = JsonFeed.getCategories();
    }

    private static void getNames() throws InterruptedException, IOException, URISyntaxException {
        Dto dto = JsonFeed.getnames();
        Main.names.put(dto.getName(), dto.getSurname());
    }
}
