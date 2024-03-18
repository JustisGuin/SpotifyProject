package edu.bsu.cs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Access {

    public static String createClientInfo() {
        String auth_string = "8f422087aab84a9eb15fb7e2547c4066" + ":" + "bf46c158ef9f49ce935f7c6972d5d2a5";
        return encode(auth_string);
    }

    public static String encode(String string) {
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getAccessToken() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization", "Basic " + createClientInfo())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            String accessToken =  jsonResponse.get("access_token").getAsString();
            return accessToken;
        }

        else {
            ErrorCatcher errorcatch = new ErrorCatcher();
            String responseToString = response.request().toString();
            int responseToInt = Integer.parseInt(responseToString);
            errorcatch.statusError(responseToInt);
        }
        return null;
    }
}