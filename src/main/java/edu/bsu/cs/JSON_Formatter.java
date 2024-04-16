package edu.bsu.cs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSON_Formatter {

    public static String formatArtist(String responseBody) {
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

    public static List<String> formatTrack(String responseBody) {
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

    public static String formatAlbum(String responseBody) {
        StringBuilder formattedOutput = new StringBuilder();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject albumsObject = jsonObject.getJSONObject("albums");
        if (albumsObject.has("items")) {
            JSONArray itemsArray = albumsObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject albumObject = itemsArray.getJSONObject(i);
                formattedOutput.append("\nAlbum ").append(i + 1).append(":\n");
                formattedOutput.append(formatAlbumID(albumObject)).append("\n");
                formattedOutput.append(formatAlbumName(albumObject)).append("\n");
                formattedOutput.append(formatAlbumArtistName(albumObject)).append("\n");
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


    public static String formatAlbumName(JSONObject albumObject){
    String albumName = albumObject.getString("name");
    return ("Album Name:"+albumName);

    }

    public static String formatAlbumArtistName(JSONObject albumObject) {
        org.json.JSONArray trackArtistsArray = albumObject.getJSONArray("artists");
        JSONObject trackArtist = trackArtistsArray.getJSONObject(0);
        String albumName = trackArtist.getString("name");
        return ("Artist Name:" + albumName);
    }

    public static String formatAlbumTracks(String responseBody){
        StringBuilder formattedOutput = new StringBuilder();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject albumTracksObject = jsonObject.getJSONObject("items");
        if (albumTracksObject.has("artists")) {
            JSONArray itemsArray = albumTracksObject.getJSONArray("artists");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject albumTracksObject2 = itemsArray.getJSONObject(i);
                formattedOutput.append(formatAlbumTracksName(albumTracksObject2)).append("\n");
            }
            if (itemsArray.isEmpty()) {
                formattedOutput.append("No results found!\n");
            }
        }
        return formattedOutput.toString();
    }

    public static String formatAlbumTracksName(JSONObject albumTracksObject2){
        return "Track name: " + albumTracksObject2.getString("name");




    }



}

