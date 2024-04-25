package edu.bsu.cs.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class GUI_Json_Formatter {
    public static String formatAlbumGUI(String json) {
        StringBuilder formattedData = new StringBuilder();
        try {
            JSONObject album = new JSONObject(json);
            formattedData.append(album.getString("name")).append("\n");
            formattedData.append(album.getJSONObject("artists").getJSONObject("items").getJSONArray("artists").getJSONObject(0).getString("name")).append("\n");
            formattedData.append(album.getString("id")).append("\n");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formattedData.toString();
    }
    public static String formatArtistGUI(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject artistsObject = jsonObject.getJSONObject("artists");
        StringBuilder formattedOutput = new StringBuilder();
        formattedOutput.append("\nShowing the top 3 responses of your query:\n\n");
        if (artistsObject.has("items")) {
            JSONArray itemsArray = artistsObject.getJSONArray("items");
            for (int i = 0; i < Math.min(3, itemsArray.length()); i++) {
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
        JSONArray genresArray = artistObject.getJSONArray("genres");
        for (int j = 0; j < genresArray.length(); j++) {
            genresOutput.append("- ").append(genresArray.getString(j)).append("\n");
        }
        return genresOutput.toString();
    }

    public static String formatPopularity(JSONObject artistObject) {
        return "Artist popularity: " + artistObject.getInt("popularity");
    }





}
