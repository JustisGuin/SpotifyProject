package edu.bsu.cs;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner;

    API_Requests apiRequests = new API_Requests();

    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public void spotifyInput() {
        String userInput = askForTypeOfSearch();

        if (userInput.isEmpty()) {
            emptyInput();
        } else if (userInput.equalsIgnoreCase("QUIT")) {
            userQuit();
        } else if (userInput.equalsIgnoreCase("1")) {
            userPickArtist();
        } else if (userInput.equalsIgnoreCase("2")) {
            userPickTrack();
        } else if (userInput.equalsIgnoreCase("3")) {
            userPickAlbum();
        }
    }

    //FOR USER CHOOSING AN ALBUM
    public void userAlbumInput() {
        String userInput = askForAlbumSelection();

        if (userInput.isEmpty()) {
            emptyInput();
        } else if (userInput.equalsIgnoreCase("QUIT")) {
            userQuit();
        } else if (userInput.equalsIgnoreCase("1")) {
            userPickArtist();
        } else if (userInput.equalsIgnoreCase("2")) {
            userPickTrack();
        } else if (userInput.equalsIgnoreCase("3")) {
            userPickAlbum();
        }
    }

    public String getUserInput(String question) {
        System.out.println(question);
        String userInput = scanner.nextLine();
        while (userInput.isEmpty()) {
            System.out.println("No entry was entered. Please enter a valid choice.\n");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    private void emptyInput() {
        System.out.println("No entry was entered. Please enter a valid choice.");
    }

    private String askForTypeOfSearch() {
        System.out.println("\"Would you like to search for a Artist (1), Track (2), or Album (3)? " +
                "\\nPlease type the number associated with your choice.\\nType B to go back\\n\"");
        return scanner.nextLine();
    }

    private String askForAlbumSelection() {
        System.out.println("\"Would you like the tracklist for albums 1, 2, or 3? " +
                "\nPLease type the number associated with your choice.\nType B to go back\n\"");
        return scanner.nextLine();
    }

    private void userQuit() {
        System.out.println("Exiting program, thank you!");
    }

    private void userPickArtist() {
        try {
            String responseBody = apiRequests.searchForArtist(Access.getAccessToken(), getUserInput("Enter name of Artist\n"));
            View.displayArtist(responseBody);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void userPickTrack() {
        try {
            String responseBody = apiRequests.searchForTrack(Access.getAccessToken(), getUserInput("Enter name of Track\n"));
            View.displayTrack(responseBody);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void userPickAlbum() {
        try {
            String responseBody = apiRequests.searchForAlbum(Access.getAccessToken(), getUserInput("Enter name of Album\n"));
            View.displayAlbum(responseBody);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}