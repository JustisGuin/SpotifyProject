package edu.bsu.cs;
import java.util.Scanner;

public class Controller {
    public static String spotifyInput(){
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
            }
        } while (true);
        scanner.close();

        return userInput;
    }
}

