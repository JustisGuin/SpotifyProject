package edu.bs.cs;

import edu.bsu.cs.JSON_Formatter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {

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
    public void testArtistName(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        jsonObject.put("name", "Polo G");
        String formattedName = JSON_Formatter.formatName(jsonObject);
        assertEquals("Polo G", formattedName);

    }
    @Test
    public void testArtistID(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        jsonObject.put("id", "6AgTAQt8XS6jRWi4sX7w49");
        String formattedID = JSON_Formatter.formatID(jsonObject);
        assertEquals("6AgTAQt8XS6jRWi4sX7w49", formattedID);

    }
    @Test
    public void testArtistPopularity(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        jsonObject.put("popularity", 81);
        int formattedPopularity = JSON_Formatter.formatPopularity(jsonObject);
        assertEquals(81, formattedPopularity);
    }
    @Test
    public void testTrackName(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/getTrackSample2.json");
        jsonObject.put("name", "Happy Birthday Songs");
        String formattedTrackName = JSON_Formatter.formatTrackName(jsonObject);
        assertEquals("Track name: Happy Birthday Songs", formattedTrackName);
    }
    @Test
    public void testTrackAlbum(){

    }
}
