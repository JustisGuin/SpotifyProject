package edu.bsu.cs;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private static final Access access = new Access();
    private final Scanner scanner;

    public Controller() {
        this.scanner = new Scanner(System.in);
    }

    public String spotifyInput() throws IOException, InterruptedException {
        String userInput;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a Artist Name, Songs, and or an Album you which to search: \n");
            userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                System.err.println("No entry was entered.\n");
            } else if (userInput.equalsIgnoreCase("Quit")) {
                break;
            } else {
                // Perform the desired search operation here
                System.out.println("Searching for: " + userInput);
                String accessToken = access.getAccessToken();
                System.out.println("Access Token");
                System.out.println(access.getAccessToken());

            }

        } while (true);

        scanner.close();

        return userInput;

    }

}

