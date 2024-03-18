package edu.bsu.cs;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller =  new Controller();
        //controller.spotifyInput();
        API_Requests APIRequests = new API_Requests();
        Access access = new Access();
        System.out.println(APIRequests.searchForArtist(Access.getAccessToken(), "Juice WLRD"));

    }

}