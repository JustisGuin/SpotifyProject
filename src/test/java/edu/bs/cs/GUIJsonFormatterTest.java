package edu.bs.cs;

import edu.bsu.cs.model.GUI_Json_Formatter;
import edu.bsu.cs.model.JSON_Formatter;
import net.minidev.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUIJsonFormatterTest {
    public static JSONObject readJSONObjectFromFile(String filename) {
        try {
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            JSONTokener tokener = new JSONTokener(fileInputStream);
            return new JSONObject(tokener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testArtistGUIName(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        assert jsonObject != null;
        jsonObject.put("name", "Polo G");
        String formattedName = GUI_Json_Formatter.formatName(jsonObject);
        assertEquals("Artist Name: Polo G", formattedName);

    }
@Test
public void testArtistPopularityGUI(){
    JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
    assert jsonObject != null;
    jsonObject.put("popularity", 81);
    String formattedPopularity = GUI_Json_Formatter.formatPopularity(jsonObject);
    assertEquals("Artist popularity: 81", formattedPopularity);
}
@Test
public void testAlbumIDGUI(){
    JSONObject albumObject = new JSONObject();
    albumObject.put("id", "ABC12345");
    String formattedID = GUI_Json_Formatter.formatAlbumID(albumObject);
    assertEquals("\nAlbum ID: ABC12345", formattedID);


}
    @Test
    public void testAlbumNameGUI(){
        JSONObject albumObject = new JSONObject();
        albumObject.put("name", "Test Album");
        String formattedName = GUI_Json_Formatter.formatAlbumName(albumObject);
        assertEquals("\nAlbum Name: Test Album", formattedName);
    }

    @Test
    public void testAlbumArtistNameGUI(){
        JSONObject albumObject = new JSONObject();
        JSONArray artistsArray = new JSONArray();
        JSONObject artistObject = new JSONObject();
        artistObject.put("name", "Artist Name Test");
        artistsArray.add(artistObject);
        albumObject.put("artists", artistsArray);

        String formattedName = GUI_Json_Formatter.formatAlbumArtistName(albumObject);

        assertEquals("\nArtist Name:Artist Name Test", formattedName);
    }
    @Test
    public void testFormatGenresGUI(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        assert jsonObject != null;
        jsonObject.put("Genre", "Polo G");
        String formattedGenre = GUI_Json_Formatter.formatGenres(jsonObject);
        assertEquals("""
                Artist genres:
                - chicago rap
                - rap
                """, formattedGenre);


    }
    @Test
    public void testFormatTracksGUI() {
        JSONObject trackObject = new JSONObject();
        trackObject.put("name", "Sample Track");
        JSONArray artistsArray = new JSONArray();
        JSONObject artistObject = new JSONObject();
        artistObject.put("name", "Sample Artist");
        artistsArray.add(artistObject);
        trackObject.put("artists", artistsArray);

        int index = 1;

        String expected = "1:\nTrack name: Sample Track\nArtist Name: Sample Artist";

        String actual = GUI_Json_Formatter.formatTrackInfo(trackObject, index);

        assertEquals(expected, actual);


    }
    @Test
    public void testFormatAlbumTracksNameGUI(){
        JSONObject albumTracksObject = new JSONObject();
        albumTracksObject.put("name", "Track Name Test");
        String formattedName = JSON_Formatter.formatAlbumTracksName(albumTracksObject);
        assertEquals("Track name: Track Name Test", formattedName);
    }
}
