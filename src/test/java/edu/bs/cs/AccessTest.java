package edu.bs.cs;


import edu.bsu.cs.Access;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AccessTest {

    @Test

    public void getClient(){
        String clientInfo = Access.createClientInfo();
        Assertions.assertEquals("OGY0MjIwODdhYWI4NGE5ZWIxNWZiN2UyNTQ3YzQwNjY6YmY0NmMxNThlZjlmNDljZTkzNWY3YzY5NzJkNWQyYTU=",clientInfo);
    }


    @Test

    public void testStatusCode() throws IOException, InterruptedException {
        String testConnection = Access.connection();
        Assertions.assertEquals("200", testConnection);
    }





}
