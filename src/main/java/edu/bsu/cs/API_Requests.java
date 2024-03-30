package edu.bsu.cs;

import net.minidev.json.JSONUtil;
import org.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class API_Requests {

    public String searchForArtist(String accessToken, String artistName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(artistName, StandardCharsets.UTF_8) + "&type=artist" + "&limit=3"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            return response.body();
        }
        return null;
    }

    public String searchForTrack(String accessToken, String trackName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(trackName, StandardCharsets.UTF_8) + "&type=track" + "&limit=5"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            return response.body();
        }
        return null;
    }

    public String searchForAlbum(String accessToken, String albumName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(albumName, StandardCharsets.UTF_8) + "&type=album" + "&limit=3"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            return response.body();
        }
        return null;
    }

    public String getArtistFromID(String token, String artistID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/artists/" + artistID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(responseBody);
            return responseBody;
        }
        return null;
    }

    public String getTrackFromID(String token, String trackID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/tracks/" + trackID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            //System.out.println(responseBody);
            return responseBody;
        }
        return null;
    }

    public String getAlbumFromID(String token, String albumID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/albums/" + albumID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(responseBody);
            return responseBody;

        }
        return null;
    }

    public String getAlbumTracks(String token, String albumID)throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/albums/tracks" + albumID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(responseBody);
            return responseBody;

        }
        return null;
    }


}
