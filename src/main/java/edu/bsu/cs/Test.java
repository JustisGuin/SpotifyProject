package edu.bsu.cs;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public HttpResponse<String> searchForArtist(String token, String artistName) throws IOException, InterruptedException {
        String url = "https://api.spotify.com/v1/search";
        String query = "q=" + artistName + "&type=artist&limit=1";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "?" + query))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}


    /*if (response.statusCode() == 200) {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        JsonObject artists = jsonResponse.getAsJsonObject("artists");
        JsonObject items = artists.getAsJsonObject("items");
        if (!items.isEmpty()) {
            JsonObject artist = items.getAsJsonArray("

     */