package com.jokecompany.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Utility for building http requests, calls and responses
 * 
 */
public class HttpUtil {

    private static HttpClient client;

    private HttpUtil() {
    }

    /**
     * Build a http client. Build a singleton instance of client.
     * 
     * @return client if already exists, else create a new one.
     */
    public static HttpClient buildClient() {

        if (client == null) {
            client = HttpClient.newHttpClient();
        }

        return client;
    }

    /**
     * Build request from the provided string
     * 
     * @param url to build
     * @return {@link HttpRequest}
     * @throws URISyntaxException
     */
    public static HttpRequest buildRequest(String url) throws URISyntaxException {

        return HttpRequest.newBuilder().uri(URI.create(url)).header("accept", "application/json").build();
    }

    /**
     * Send a http request
     * 
     * @param request {@link HttpRequest}
     * @return {@link String}, converted from http response
     * @throws IOException
     * @throws InterruptedException
     */
    public static String sendRequest(HttpRequest request) throws IOException, InterruptedException {

        return buildClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
