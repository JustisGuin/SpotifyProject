package edu.bs.cs;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.bsu.cs.model.API_Requests;
import org.junit.jupiter.api.Test;

public class APIRequestsTest {

    private static final String ACCESS_TOKEN = "BQBN4JZaH2gIGiM14CGyd-AA-T6RUObX_Cmag3Gq_gD7KguHb3sYpmZ3aT3W445HP4ifE3SGR4XKHoKOPQa0pwcjt9cmib8qZIAHy59dufOiEq6xOUg";

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
