package edu.bsu.cs;

import java.util.List;

public class View {
    public static void displayArtist(String responseBody) {
        String formattedData = JSON_Formatter.formatArtist(responseBody);
        System.out.println(formattedData);
    }

    public static void displayTrack(String responseBody) {
        List<String> formattedData = JSON_Formatter.formatTrack(responseBody);
        if (formattedData.isEmpty()) {
            System.out.println("No results found!");
        } else {
            System.out.println("Tracks:");
            for (String track : formattedData) {
                System.out.println(track);
            }
        }
    }

    public static void displayAlbum(String responseBody) {
        String formattedData = JSON_Formatter.formatAlbum(responseBody);
        System.out.println(formattedData);
    }
}