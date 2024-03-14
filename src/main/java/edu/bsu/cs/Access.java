package edu.bsu.cs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Access {

    public String createClientInfo() {
        String auth_string = "8f422087aab84a9eb15fb7e2547c4066" + ":" + "bf46c158ef9f49ce935f7c6972d5d2a5";
        return encode(auth_string);
    }

    public String encode(String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String connection() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization", "Basic " + createClientInfo())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            System.out.println(response.body());
            return response.body();
        } else {
            //errorCatch();
        }
        return response.body();
    }
}