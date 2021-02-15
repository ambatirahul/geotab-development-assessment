package com.jokecompany;

import com.jokecompany.Services.ConsoleService;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleService consoleService=new ConsoleService();
        consoleService.startJokeCompany();
    }

}
