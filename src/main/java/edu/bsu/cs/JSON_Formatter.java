package edu.bsu.cs;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSON_Formatter {
    static final Access access = new Access();

    public static String formatArtist(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject artistsObject = jsonObject.getJSONObject("artists");
        StringBuilder formattedOutput = new StringBuilder();
        formattedOutput.append("\nShowing the top 3 responses of your query:\n\n");
        if (artistsObject.has("items")) {
            org.json.JSONArray itemsArray = artistsObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject artistObject = itemsArray.getJSONObject(i);
                formattedOutput.append(formatName(artistObject)).append("\n");
                formattedOutput.append(formatID(artistObject)).append("\n");
                formattedOutput.append(formatGenres(artistObject)).append("\n");
                formattedOutput.append(formatPopularity(artistObject)).append("\n\n");
            }
            if (itemsArray.isEmpty()) {
                formattedOutput.append("No results found!\n");
            }
        }
        return formattedOutput.toString();
    }

    public static String formatName(JSONObject artistObject) {
        return "Artist Name: " + artistObject.getString("name");
    }

    public static String formatID(JSONObject artistObject) {
        return "Artist ID: " + artistObject.getString("id");
    }

    public static String formatGenres(JSONObject artistObject) {
        StringBuilder genresOutput = new StringBuilder("Artist genres:\n");
        org.json.JSONArray genresArray = artistObject.getJSONArray("genres");
        for (int j = 0; j < genresArray.length(); j++) {
            genresOutput.append("- ").append(genresArray.getString(j)).append("\n");
        }
        return genresOutput.toString();
    }

    public static String formatPopularity(JSONObject artistObject) {
        return "Artist popularity: " + artistObject.getInt("popularity");
    }

    public static List<String> formatTrack(String responseBody) {
        List<String> formattedSearch = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject tracksObject = jsonObject.getJSONObject("tracks");
        if (tracksObject.has("items")) {
            org.json.JSONArray itemsArray = tracksObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject trackObject = itemsArray.getJSONObject(i);
                formattedSearch.add(formatTrackInfo(trackObject));
            }
            if (itemsArray.isEmpty()) {
                formattedSearch.add("No results found!");
            }
        }
        return formattedSearch;
    }

    public static String formatTrackInfo(JSONObject trackObject) {
        String trackName = "Track name: " + trackObject.getString("name");
        String artistName = "Artist Name: " + trackObject.getJSONArray("artists").getJSONObject(0).getString("name");
        return trackName + "\n" + artistName;
    }

    public static String formatAlbum(String responseBody) {
        StringBuilder formattedOutput = new StringBuilder();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject albumsObject = jsonObject.getJSONObject("albums");
        if (albumsObject.has("items")) {
            org.json.JSONArray itemsArray = albumsObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject albumObject = itemsArray.getJSONObject(i);
                formattedOutput.append(formatAlbumID(albumObject)).append("\n");
            }
            if (itemsArray.isEmpty()) {
                formattedOutput.append("No results found!\n");
            }
        }
        return formattedOutput.toString();
    }

    public static String formatAlbumID(JSONObject albumObject) {
        return "Album ID: " + albumObject.getString("id");
    }
}