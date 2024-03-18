package edu.bsu.cs;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller =  new Controller();
        //controller.spotifyInput();

        //tests for sam
        API_Requests APIRequests = new API_Requests();
        Access access = new Access();
        System.out.println(APIRequests.getTrackFromID(Access.getAccessToken(), "3cWmqvMwVQKDigWLSZ3w9h"));

    }

}