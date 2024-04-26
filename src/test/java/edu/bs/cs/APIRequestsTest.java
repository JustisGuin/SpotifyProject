package edu.bs.cs;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.bsu.cs.model.API_Requests;
import edu.bsu.cs.model.Access;
import org.junit.jupiter.api.Test;

public class APIRequestsTest {

    public static final String ACCESS_TOKEN = Access.getAccessToken();

    @Test
    public void testSearchForArtist() throws IOException, InterruptedException {
        String artistName = "Billie Eilish";
        API_Requests searchService = new API_Requests();
        String response = searchService.searchForArtist(ACCESS_TOKEN, artistName);
        assertNotNull(response);
    }
    @Test
    public void testSearchForTrack() throws IOException, InterruptedException {
        String trackName = "Rockstar Made";
        API_Requests searcher = new API_Requests();
        String response = searcher.searchForTrack(ACCESS_TOKEN, trackName);
        assertNotNull(response);
    }
    @Test
    public void testSearchForAlbum() throws IOException, InterruptedException{
        String albumName = "UTOPIA";
        API_Requests searcher = new API_Requests();
        String response = searcher.searchForAlbum(ACCESS_TOKEN, albumName);
        assertNotNull(response);
    }

}
