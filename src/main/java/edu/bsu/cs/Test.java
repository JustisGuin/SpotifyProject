package edu.bsu.cs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public String searchForArtist(String token, String artistName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(artistName, "utf-8") + "&type=artist"))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);

            // The search results are inside the 'artists' object
            JSONObject artistsObject = jsonObject.getJSONObject("artists");

            // Check if there are any items (artists) in the response
            if (artistsObject.has("items")) {
                JSONArray itemsArray = artistsObject.getJSONArray("items");

                // Loop through the array of artist objects
                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject artistObject = itemsArray.getJSONObject(i);

                    // Extract the artist name
                    String getArtistName = artistObject.getString("name");
                    System.out.println("Artist name: " + getArtistName);

                    // Extract the artist ID
                    String getArtistID = artistObject.getString("name");
                    System.out.println("Artist name: " + getArtistID);

                    // Extract the artist ID
                    String artistId = artistObject.getString("id");
                    System.out.println("Artist ID: " + artistId);

                    // Extract the artist's popularity
                    int popularity = artistObject.getInt("popularity");
                    System.out.println("Artist popularity: " + popularity);

                    // Extract the artist's genres
                    JSONArray genresArray = artistObject.getJSONArray("genres");
                    System.out.println("Artist genres:");
                    for (int j = 0; j < genresArray.length(); j++) {
                        String genre = genresArray.getString(j);
                        System.out.println("- " + genre);
                    }

                    System.out.println();
                }
            } else {
                System.out.println();
                }
            return responseBody;
            }
        return null;
        }

    }

