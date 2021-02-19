package com.jokecompany.Services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestBuilder {
    public String buildRequestAndSend(HttpClient client, String url) throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI(url);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        //return the response body
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        //get joke

    }
}
