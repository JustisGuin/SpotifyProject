package edu.bs.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class APITest {

    @Test

    public void getClient() throws Exception{

        String clientID = "8f422087aab84a9eb15f-be7e2547c4066";
        String clientSecret= "bf46c158e-f9ce935f7c6972d52af";




        Assertions.assertEquals("8f422087aab84a9eb15f-be7e2547c4066",clientID);
        Assertions.assertEquals("bf46c158e-f9ce935f7c6972d52af",clientSecret);

    }
}
