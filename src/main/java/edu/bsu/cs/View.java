package edu.bsu.cs;

import java.util.List;

public class View {
    public static void displayArtist(String artistName, String artistId, List<String> genres, int popularity) {
        System.out.println();
        System.out.println("Showing the top 3 responses of your query:");
        System.out.println("Artist Name: " + artistName);
        System.out.println("Artist ID: " + artistId);
        System.out.println("Artist genres:");
        for (String genre : genres) {
            System.out.println("- " + genre);
        }
        System.out.println("Artist popularity: " + popularity);
        System.out.println();
    }

    public static void displayTrack(List<String> trackData) {
        if (trackData.isEmpty()) {
            System.out.println("No results found!");
            return;
        }
        System.out.println("Tracks:");
        for (int i = 0; i < trackData.size(); i++) {
            System.out.printf("%d:%n%s%n%n", i + 1, trackData.get(i));
        }
    }

    public static void displayAlbum(String albumID) {
        System.out.println("Album ID: " + albumID);
    }

    public static void displayNoResults() {
        System.out.println("No results found!");
    }
}