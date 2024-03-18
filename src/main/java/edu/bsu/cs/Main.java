package edu.bsu.cs;
import java.io.IOException;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller =  new Controller();
        //controller.spotifyInput();
        Test test = new Test();
        Access access = new Access();
        System.out.println(test.searchForArtist(Access.getAccessToken(), "Juice_WRLD"));

    }

}