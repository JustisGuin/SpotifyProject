package edu.bsu.cs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static edu.bsu.cs.Formatter.access;

public class Controller {



    private final Scanner scanner;

    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public String spotifyInput() throws IOException, InterruptedException {
        System.out.println("Enter a Artist Name, Songs, and or an Album you which to search: \n");
        String userInput = scanner.nextLine();

        if (userInput.isEmpty()) {
            System.err.println("No entry was entered.\n");
            userInput = spotifyInput();
        } else if (userInput.equalsIgnoreCase("quit")) {
            return null;
        } else {
            System.out.println("Searching for: " + userInput);
            String accessToken = access.getAccessToken();
            System.out.println("Access Token: " + accessToken);
        }

        return userInput;
    }

    public void run() throws IOException, InterruptedException {
        String userInput;
        do {
            userInput = spotifyInput();

            if (userInput != null) {
                Formatter.format(userInput);

            }
        } while (userInput != null);

        scanner.close();
    }

}