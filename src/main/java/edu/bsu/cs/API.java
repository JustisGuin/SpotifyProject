package edu.bsu.cs;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class API {

    public String getToken(){
        String auth_string = "8f422087aab84a9eb15f-be7e2547c4066" + ":" + "bf46c158e-f9ce935f7c6972d52af";
        String auth_bytes = encode(auth_string);
        return auth_bytes;
    }
    public String encode(String string){
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        String base64EncodedString = Base64.getEncoder().encodeToString(bytes);
        System.out.println(base64EncodedString);
        return base64EncodedString;
    }

}
