package edu.bs.cs;


import edu.bsu.cs.model.Access;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AccessTest {

    @Test

    public void getClient() throws IOException {
        Access access = new Access();
        String clientInfo = access.createClientInfo();
        Assertions.assertEquals("OGY0MjIwODdhYWI4NGE5ZWIxNWZiN2UyNTQ3YzQwNjY6YmY0NmMxNThlZjlmNDljZTkzNWY3YzY5NzJkNWQyYTU=",clientInfo);
    }


    @Test

    public void testStatusCode() throws IOException, InterruptedException {
        Access access = new Access();
        String testConnection = access.getAccessToken();
        Assertions.assertNotNull(testConnection);
    }





}
