package edu.bsu.cs;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner;

    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public String spotifyInput() throws IOException, InterruptedException {
        API_Requests apiRequests = new API_Requests();
        Access access = new Access();
        System.out.println("Would you like to search for a Artist (1), Track (2), or Album (3)? \nPlease type the number associated with your choice.\n");
        String userInput = scanner.nextLine();

        if (userInput.isEmpty()) {
            System.err.println("No entry was entered. Please enter a valid choice.\n");
            userInput = spotifyInput();
        } else if (userInput.equalsIgnoreCase("quit")) {
            System.err.println("Exiting program.\n");
            return null;
        } else if (userInput.equalsIgnoreCase("1")) {

            apiRequests.searchForArtist(Access.getAccessToken(),getUserInput("Enter name of Artist\n"));
        }

        return userInput;
    }

    public void run() throws IOException, InterruptedException {
        spotifyInput();
    }

    public String getUserInput(String question){
        System.out.println(question);
        String userInput = scanner.nextLine();
        return userInput;
    }

}