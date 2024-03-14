package edu.bsu.cs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Access {
    //main class is only here for testing purposes. connection() should be called by another function later in the project
    public static void main(String[] args) throws IOException, InterruptedException {
        String connection = connection();
    }

    public static String createClientInfo() {
        String auth_string = "8f422087aab84a9eb15fb7e2547c4066" + ":" + "bf46c158ef9f49ce935f7c6972d5d2a5";
        return encode(auth_string);
    }

    public static String encode(String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String connection() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization", "Basic " + createClientInfo())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response);
        if (response.statusCode() == 200) {
            String body = response.body();
            int startIndex = body.indexOf("access_token") + 13;
            int endIndex = body.indexOf(",", startIndex);
            //System.out.println(body.substring(startIndex, endIndex));
            System.out.println(response.body());



        }
        String status = String.valueOf(response.statusCode());
        return status;
    }
}