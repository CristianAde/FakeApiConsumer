/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avirato.service;

import com.avirato.model.service.Data;
import com.avirato.model.service.Datum;
import com.avirato.model.service.Root;
import com.avirato.model.service.RootCreate;
import com.avirato.model.service.RootLogin;
import com.avirato.model.service.RootSingle;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import static javax.ws.rs.HttpMethod.GET;

/**
 *
 * @author Cristian
 */
public class UserApiService {

    public ArrayList<Datum> getAllUserRequest() throws MalformedURLException, IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Authorization", "Bearer {token}");
        http.setRequestMethod(GET);
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(http.getURL(), Root.class);
        System.out.println(http.getResponseCode());
        return root.getData();
    }

    public Data getSingleUser(int id) throws IOException {
        ObjectMapper om = new ObjectMapper();
        RootSingle rootSingle = om.readValue(new URL("https://reqres.in/api/users/" + id), RootSingle.class);
        return rootSingle.getData();
    }

    public int postUserRequest() throws IOException, InterruptedException {
        final ObjectMapper objectMapper = new ObjectMapper();
        RootCreate user = new RootCreate("Cristian", "Desarrollador");
        String requestBody = objectMapper
                .writeValueAsString(user);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body() + response.statusCode());

        return response.statusCode();
    }

    public int putUserRequest(String name, String phone) throws IOException, InterruptedException {
        final ObjectMapper objectMapper = new ObjectMapper();
        RootCreate user = new RootCreate(name, phone);
        String requestBody = objectMapper
                .writeValueAsString(user);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode() + " / " + response.body());
        return response.statusCode();
    }

    public int deleteUserRequest(int customer) throws IOException, InterruptedException {

        String deleteEndpoint = "https://reqres.in/api/users/" + customer;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(deleteEndpoint))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        return response.statusCode();
    }

    public void loginRequestRootLogin(RootLogin rootLogin) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(rootLogin);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/login"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body() + "\n" + response.headers());
    }

}
