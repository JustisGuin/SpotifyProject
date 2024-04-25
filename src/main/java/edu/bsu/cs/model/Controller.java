package edu.bsu.cs.model;

import edu.bsu.cs.view.View;

import java.util.Scanner;

public class Controller {

    private final Scanner scanner;

    API_Requests apiRequests = new API_Requests();
    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        System.out.println(welcome());
        sleeper(5000);
        spotifyInput();
    }

    public static void sleeper(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            ErrorCatcher.sleepError();
        }
    }

    private String welcome() {
        return """

                Welcome to 'SpotifyProject', brought to you by Group A;
                Justis Guin, Ethan Ramsell, Joe Mitchell, & Sam Brumley
                We hope you enjoy!
                """;
    }

    public void spotifyInput() {
        String userInput = askForTypeOfSearch();
        if (userInput.isEmpty()) {
            emptyInput();
        } else if (userInput.equalsIgnoreCase("QUIT")) {
            userQuit();
        } else if (userInput.equals("1")) {
            userPickArtist();
        } else if (userInput.equals("2")) {
            userPickTrack();
        } else if (userInput.equals("3")) {
            userPickAlbum();
        } else{
            System.out.println(invalidInput());
            spotifyInput();
        }
    }

    private String invalidInput() {
        return "Not a valid input! Please try again.\n";
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
        System.out.println("""
                "Would you like to search for a Artist (1), Track (2), or Album (3)? \

                Please type the number associated with your choice.
                Type QUIT to exit.
                """);
        return scanner.nextLine();
    }

    private void userQuit() {
        System.out.println("Exiting program, thank you!");
    }

    private void userPickArtist() {
        try {
            String responseBody = apiRequests.searchForArtist(Access.getAccessToken(), getUserInput("Enter name of Artist\n"));
            View.displayArtist(responseBody);
        } catch (NumberFormatException e) {
            ErrorCatcher.configPropertiesError();
        }
        catch (Exception e){
            ErrorCatcher.printUnknownError();
        }
    }

    private void userPickTrack() {
        try {
            String responseBody = apiRequests.searchForTrack(Access.getAccessToken(), getUserInput("Enter name of Track\n"));
            View.displayTrack(responseBody);
        } catch (NumberFormatException e) {
            ErrorCatcher.configPropertiesError();
        }
        catch (Exception e){
            ErrorCatcher.printUnknownError();
        }
    }

    private void userPickAlbum() {
        try {
            String responseBody = apiRequests.searchForAlbum(Access.getAccessToken(), getUserInput("Enter name of Album\n"));
            View.displayAlbum(responseBody);
            System.out.println(JSON_Formatter.grabAlbumArt(responseBody));
        } catch (NumberFormatException e) {
            ErrorCatcher.configPropertiesError();
        }
        catch (Exception e){
            ErrorCatcher.printUnknownError();
        }
    }
}