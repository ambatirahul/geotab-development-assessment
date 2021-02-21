package com.jokecompany;

import java.io.IOException;

import com.jokecompany.interfaces.IUser;
import com.jokecompany.services.UserImpl;

public class Main {

    public static void main(String[] args) throws IOException {

        // Initialize the user and the company
        IUser iUser = new UserImpl();
        iUser.startCompany();
    }

}
