package edu.bsu.cs.model;

import javafx.scene.control.TextField;

import java.util.List;

public class View {
    public static void displayArtist(String responseBody, TextField outputField) {
        String formattedData = JSON_Formatter.formatArtist(responseBody);
      //  System.out.println(formattedData);
        outputField.appendText(formattedData);

    }

    public static void displayTrack(String responseBody) {
        List<String> formattedData = JSON_Formatter.formatTrack(responseBody);
        if (formattedData.isEmpty()) {
            System.out.println("No results found!");
        } else {
            System.out.println("Tracks:");
            for (String track : formattedData) {
                Controller.sleeper(1000);
                System.out.println(track);
            }
        }
    }

    public static void displayAlbum(String responseBody){
        List<StringBuilder> formattedAlbums = JSON_Formatter.formatAlbum(responseBody);
        if (formattedAlbums.isEmpty()) {
            System.out.println("No results found!");
        } else {
            System.out.println("Albums:");
            for (StringBuilder album : formattedAlbums) {
                Controller.sleeper(1000);
                System.out.println(album);
            }
        }
    }
}