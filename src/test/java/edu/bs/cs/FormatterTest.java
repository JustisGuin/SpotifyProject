package edu.bs.cs;

import edu.bsu.cs.model.JSON_Formatter;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        assertEquals("Artist Name: Polo G", formattedName);

    }
    @Test
    public void testArtistID(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        jsonObject.put("id", "6AgTAQt8XS6jRWi4sX7w49");
        String formattedID = JSON_Formatter.formatID(jsonObject);
        assertEquals("Artist ID: 6AgTAQt8XS6jRWi4sX7w49", formattedID);

    }
    @Test
    public void testArtistPopularity(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/testArtistSample.json");
        jsonObject.put("popularity", 81);
        String formattedPopularity = JSON_Formatter.formatPopularity(jsonObject);
        assertEquals("Artist popularity: 81", formattedPopularity);
    }
    @Test
    public void testAlbumID(){
        JSONObject jsonObject = readJSONObjectFromFile("src/test/resources/getAlbumSample2.json");
        jsonObject.put("id", "18NOKLkZETa4sWwLMIm0UZ");
        String formattedID = JSON_Formatter.formatAlbumID(jsonObject);
        assertEquals("Album ID: 18NOKLkZETa4sWwLMIm0UZ", formattedID);


    }
}
