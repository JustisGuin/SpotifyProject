package edu.bsu.cs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Formatter {
    static final Access access = new Access();
    public static String format(String responseBody,){
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

    public static void printArtist(String artistName) throws IOException, InterruptedException {
        API_Requests apiRequests = new API_Requests();
        String jsonObjectString = apiRequests.searchForArtist(access.getAccessToken(), artistName);
        if (jsonObjectString != null) {
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            if (jsonObject.has("artists")) {
                JSONObject artists = jsonObject.getJSONObject("artists");
                if (artists.has("items")) {
                    JSONArray items = artists.getJSONArray("items");
                    if (items.length() > 0) {
                        JSONObject firstArtist = items.getJSONObject(0);
                        System.out.println("Artist Name: " + firstArtist.getString("name"));
                        System.out.println("Followers: " + firstArtist.getJSONObject("followers").getInt("total"));
                        System.out.println("Genres: " + firstArtist.getJSONArray("genres").toString());
                    } else {
                        System.out.println("No artists found.");
                    }
                } else {
                    System.out.println("No artists found.");
                }
            } else {
                System.out.println("No artists found.");
            }
        } else {
            System.out.println("Artist not found. Please try again.");
        }
    }


}
