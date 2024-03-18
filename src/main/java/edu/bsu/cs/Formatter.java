package edu.bsu.cs;

import org.json.JSONObject;

public class Formatter {
    public static String format(String responseBody){
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject artistsObject = jsonObject.getJSONObject("artists");
        if (artistsObject.has("items")) {
            org.json.JSONArray itemsArray = artistsObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject artistObject = itemsArray.getJSONObject(i);
                formatID(artistObject);
                formatGenres(artistObject);
                formatPopularity(artistObject);
    }
        }
        return responseBody;
    }
    public static void formatID(JSONObject artistObject){
        String artistId = artistObject.getString("id");
        System.out.println("Artist ID: " + artistId);
    }
    public static void formatGenres(JSONObject artistObject){
        org.json.JSONArray genresArray = artistObject.getJSONArray("genres");
        System.out.println("Artist genres:");
        for (int j = 0; j < genresArray.length(); j++) {
            String genre = genresArray.getString(j);
            System.out.println("- " + genre);
        }

    }
    public static void formatPopularity(JSONObject artistObject){
        int popularity = artistObject.getInt("popularity");
        System.out.println("Artist popularity: " + popularity);
    }
    public static String formatTrack(String responseBody){
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject tracksObject = jsonObject.getJSONObject("tracks");
        if (tracksObject.has("tracks")) {
            org.json.JSONArray itemsArray = tracksObject.getJSONArray("tracks");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject trackObject = itemsArray.getJSONObject(i);
                formatTrackName(trackObject);
            }
        }
        return responseBody;
    }
    public static void formatTrackName(JSONObject trackObject){
        String trackName = trackObject.getString("name");
        System.out.println("Track name: " + trackName);
    }


}
