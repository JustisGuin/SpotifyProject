package edu.bsu.cs;

import org.json.JSONObject;

public class JSON_Formatter {
    static final Access access = new Access();

    //FORMAT ARTISTS
    public static String formatArtist(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject artistsObject = jsonObject.getJSONObject("artists");
        if (artistsObject.has("items")) {
            org.json.JSONArray itemsArray = artistsObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject artistObject = itemsArray.getJSONObject(i);
                formatName(artistObject);
                formatID(artistObject);
                formatGenres(artistObject);
                formatPopularity(artistObject);
                System.out.println();
            }
        }
        return responseBody;
    }
    public static void formatName(JSONObject artistObject){
        String artistName = artistObject.getString("name");
        System.out.println("Artist Name: " + artistName);
    }

    public static void formatID(JSONObject artistObject) {
        String artistId = artistObject.getString("id");
        System.out.println("Artist ID: " + artistId);
    }

    public static void formatGenres(JSONObject artistObject) {
        org.json.JSONArray genresArray = artistObject.getJSONArray("genres");
        System.out.println("Artist genres:");
        for (int j = 0; j < genresArray.length(); j++) {
            String genre = genresArray.getString(j);
            System.out.println("- " + genre);
        }

    }

    public static void formatPopularity(JSONObject artistObject) {
        int popularity = artistObject.getInt("popularity");
        System.out.println("Artist popularity: " + popularity);
    }

    //FORMAT TRACKS


    public static String formatTrack(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject tracksObject = jsonObject.getJSONObject("tracks");
        if (tracksObject.has("items")) {
            org.json.JSONArray itemsArray = tracksObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject trackObject = itemsArray.getJSONObject(i);
                System.out.print(trackObject);
                formatTrackName(trackObject);
                //formatTrackAlbum(trackObject);
                //formatTrackArtists(trackObject);
            }

        }return responseBody;
    }

    public static String formatTrackName(JSONObject trackObject) {
        String trackName = trackObject.getString("name");
        String label =("Track name: " + trackName);
        System.out.print(label);
        return label;

    }

    public static String formatTrackAlbum(JSONObject trackObject) {
        String trackAlbum = trackObject.getString("album");
        String label =("Track album: " + trackAlbum);
        System.out.print(label);
        return label;
    }

    public static void formatTrackArtists(JSONObject trackObject) {
        org.json.JSONArray trackArtistsArray = trackObject.getJSONArray("artists");
        System.out.println("Artists on track: ");
        for (int j = 0; j < trackArtistsArray.length(); j++) {
            String artist = trackArtistsArray.getString(j);
            System.out.println("- " + artist);
        }
    }

    //FORMAT ALBUMS
    public static String formatAlbum(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject albumsObject = jsonObject.getJSONObject("albums");
        if (albumsObject.has("albums")) {
            org.json.JSONArray itemsArray = albumsObject.getJSONArray("albums");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject albumObject = itemsArray.getJSONObject(i);

            }


        }
        return responseBody;
    }
    public static void formatAlbumTracklist(JSONObject albumObject){
        org.json.JSONArray genresArray = albumObject.getJSONArray("tracks");
        System.out.println("Album Tracklist:");
        for (int j = 0; j < genresArray.length(); j++) {
            String genre = genresArray.getString(j);
            System.out.println("- " + genre);
        }


    }

}
