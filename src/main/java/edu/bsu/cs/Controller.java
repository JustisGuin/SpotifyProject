package edu.bsu.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Controller {

    private final Scanner scanner;

    ErrorCatcher errorCatcher = new ErrorCatcher();
    Access access = new Access();
    JSON_Formatter formatter = new JSON_Formatter();
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
    public String getUserInput(String question){
        System.out.println(question);
        String userInput = scanner.nextLine();
        while (userInput.isEmpty()) {
            System.out.println("No entry was entered. Please enter a valid choice.\n");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    private void emptyInput(){
        System.out.println("No entry was entered. Please enter a valid choice.");;
    }

    private String askForTypeOfSearch(){
        System.out.println("\"Would you like to search for a Artist (1), Track (2), or Album (3)? " +
                "\\nPlease type the number associated with your choice.\\nType B to go back\\n\"");
        return scanner.nextLine();
    }

    private String userQuit(){
        return "Exiting program, thank you!";
    }

    private void userPickArtist(){
        try {
            JSON_Formatter.formatArtist(apiRequests.searchForArtist(Access.getAccessToken(), getUserInput("Enter name of Artist\n")));
            String artistName = "";
            while (artistName.isEmpty()) {
                artistName = getUserInput("");
                if (artistName.isEmpty()) {
                    System.out.println("No artist name was provided. Please enter a valid artist name.\n");
                }
                JSON_Formatter.formatArtist(apiRequests.searchForArtist(Access.getAccessToken(), artistName));
            }} catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void userPickTrack(){
        List<String> trackData = new ArrayList<>();
        try {
            trackData = (JSON_Formatter.formatTrack(apiRequests.searchForTrack(Access.getAccessToken(), getUserInput("Enter name of Track\n"))));
            for (int i = 0; i < trackData.size(); i++)
                System.out.printf("\n\nTrack %d\n %s", i + 1, trackData.get(i));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void userPickAlbum(){
        try {
            JSON_Formatter.formatAlbum(apiRequests.searchForAlbum(Access.getAccessToken(), getUserInput("Enter name of Album\n")));
            String albumName = "";
            while (albumName.isEmpty()) {
                albumName = getUserInput("");
                if (albumName.isEmpty()) {
                    System.out.println("No artist name was provided. Please enter a valid artist name.\n");
                }
                JSON_Formatter.formatArtist(apiRequests.searchForArtist(Access.getAccessToken(), albumName));
            } }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}