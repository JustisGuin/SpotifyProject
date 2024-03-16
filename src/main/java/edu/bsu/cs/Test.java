package edu.bsu.cs;

import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public String searchForArtist(String token, String artistName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search"))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return String.valueOf(response);}}
/*
        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            JsonObject error = jsonResponse.getAsJsonObject("error");
            if (error != null) {
                throw new IOException("Error in the response: " + error.get("message").getAsString());
            }

            JsonObject artists = jsonResponse.getAsJsonObject("artists");
            JsonObject items = artists.getAsJsonObject("items");
            if (!items.isEmpty()) {
                JsonObject artist = items.getAsJsonArray("items").getJsonObject(0);
                return artist.get("id").getAsString();
            }
        } else {
            throw new IOException("Unexpected response status: " + response.statusCode());
        }

        return null; // Return null if no artist is found
    }

 */