package edu.bsu.cs;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner;

    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public void spotifyInput() throws IOException, InterruptedException {
        API_Requests apiRequests = new API_Requests();
        Access access = new Access();

        System.out.println("Would you like to search for an Artist (1), Track (2), or Album (3)? \nPlease type the number associated with your choice.\nType B to go back\n");
        String userInput = scanner.nextLine();

        if (userInput.isEmpty()) {
            System.err.println("No entry was entered. Please enter a valid choice.\n");
            spotifyInput();
        } else if (userInput.equalsIgnoreCase("quit")) {
            System.err.println("Exiting program.\n");
            return;
        } else if (userInput.equalsIgnoreCase("1")) {
            String artistName = getUserInput("Enter name of Artist\n");
            String responseBody = apiRequests.searchForArtist(Access.getAccessToken(), artistName);
            if (responseBody != null) {
                String formattedData = JSON_Formatter.formatArtist(responseBody);
                System.out.println(formattedData);
            } else {
                View.displayNoResults();
            }
        } else if (userInput.equalsIgnoreCase("2")) {
            String trackName = getUserInput("Enter name of Track\n");
            String responseBody = apiRequests.searchForTrack(Access.getAccessToken(), trackName);
            if (responseBody != null) {
                List<String> trackData = JSON_Formatter.formatTrack(responseBody);
                if (!trackData.isEmpty()) {
                    for (String trackInfo : trackData) {
                        System.out.println(trackInfo);
                    }
                } else {
                    View.displayNoResults();
                }
            } else {
                View.displayNoResults();
            }
        } else if (userInput.equalsIgnoreCase("3")) {
            String albumName = getUserInput("Enter name of Album\n");
            String responseBody = apiRequests.searchForAlbum(Access.getAccessToken(), albumName);
            if (responseBody != null) {
                String formattedData = JSON_Formatter.formatAlbum(responseBody);
                System.out.println(formattedData);
            } else {
                View.displayNoResults();
            }
        }
    }

    private String getUserInput(String question) {
        System.out.println(question);
        String userInput = scanner.nextLine();
        while (userInput.isEmpty()) {
            System.out.println("No entry was entered. Please enter a valid choice.\n");
            userInput = scanner.nextLine();
        }
        return userInput;
    }
}