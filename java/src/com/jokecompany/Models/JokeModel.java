package com.jokecompany.Models;

/**
 * joke variables from api call
 */
public class JokeModel {
    private String Id;
    private String value;
    private String message;
    private String url;
    private String icon_url;
    private String created_at;

    public String getValue() {
        return value;
    }
    public String getMessage() {
        return message;
    }
}
