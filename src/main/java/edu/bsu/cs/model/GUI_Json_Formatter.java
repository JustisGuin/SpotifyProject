package edu.bsu.cs.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class GUI_Json_Formatter {
    public static List<StringBuilder> formatAlbumGUI(String responseBody) {
        List<StringBuilder> formattedAlbums = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject albumsObject = jsonObject.getJSONObject("albums");
        if (albumsObject.has("items")) {
            JSONArray itemsArray = albumsObject.getJSONArray("items");
            for (int i = 0; i < Math.min(5, itemsArray.length()); i++) {
                JSONObject albumObject = itemsArray.getJSONObject(i);
                formattedAlbums.add(formatAlbumInfo(albumObject));
            }
            if (itemsArray.isEmpty()) {
                formattedAlbums.add(new StringBuilder("No results found!"));
            }
        }
        return formattedAlbums;
    }

    private static StringBuilder formatAlbumInfo(JSONObject albumObject) {
        StringBuilder albumStringBuilder = new StringBuilder();
        albumStringBuilder.append(formatAlbumName(albumObject));
        albumStringBuilder.append(formatAlbumArtistName(albumObject));
        albumStringBuilder.append(formatAlbumID(albumObject));

        return albumStringBuilder;
    }

    public static String formatAlbumID(JSONObject albumObject) {
        return "\nAlbum ID: " + albumObject.getString("id");

    }

    public static String formatAlbumName(JSONObject albumObject){
        String albumName = albumObject.getString("name");
        return ("\nAlbum Name: "+albumName);

    }

    public static String formatAlbumArtistName(JSONObject albumObject) {
        org.json.JSONArray trackArtistsArray = albumObject.getJSONArray("artists");
        JSONObject trackArtist = trackArtistsArray.getJSONObject(0);
        String albumName = trackArtist.getString("name");
        return ("\nArtist Name:" + albumName);
    }
    public static String formatArtistGUI(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject artistsObject = jsonObject.getJSONObject("artists");
        StringBuilder formattedOutput = new StringBuilder();
        System.out.println("\n");
        formattedOutput.append("Showing the top 3 responses of your query:\n\n");
        if (artistsObject.has("items")) {
            JSONArray itemsArray = artistsObject.getJSONArray("items");
            for (int i = 0; i < Math.min(3, itemsArray.length()); i++) {
                JSONObject artistObject = itemsArray.getJSONObject(i);
                formattedOutput.append(formatName(artistObject));
                formattedOutput.append(formatID(artistObject));
                formattedOutput.append(formatGenres(artistObject));
                formattedOutput.append(formatPopularity(artistObject));
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
        return "Artist ID:\n " + artistObject.getString("id");
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

    public static List<String> formatTrackGUI(String responseBody) {
        List<String> formattedTracks = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject tracksObject = jsonObject.getJSONObject("tracks");
        if (tracksObject.has("items")) {
            JSONArray itemsArray = tracksObject.getJSONArray("items");
            for (int i = 0; i < Math.min(5, itemsArray.length()); i++) {
                JSONObject trackObject = itemsArray.getJSONObject(i);
                formattedTracks.add(formatTrackInfo(trackObject, i + 1));
            }
            if (itemsArray.isEmpty()) {
                formattedTracks.add("No results found!");
            }
        }
        return formattedTracks;
    }

    public static String formatTrackInfo(JSONObject trackObject, int index) {
        String trackName = trackObject.getString("name");
        JSONArray artistsArray = trackObject.getJSONArray("artists");
        String artistName = artistsArray.getJSONObject(0).getString("name");
        return index + ":\nTrack name: " + trackName + "\nArtist Name: " + artistName;
    }





}
