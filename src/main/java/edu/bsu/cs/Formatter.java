package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Formatter {
    public static String formatFollowers(String jsonData){
        JSONArray followers = (JSONArray) JsonPath.read(jsonData, "followers");
        System.out.println("Artist Followers: ");
        return jsonData;
    }
    public static String formatGenres(String jsonData){
        JSONArray genres = (JSONArray) JsonPath.read(jsonData,"genres");
        System.out.println("Artist's Genres: ");
        return jsonData;
    }
    public static String formatPopularity(String jsonData){
        JSONArray popularity = (JSONArray) JsonPath.read(jsonData, "popularity");
        System.out.println("Artists Popularity Rank: ");
        return jsonData;
    }

}
