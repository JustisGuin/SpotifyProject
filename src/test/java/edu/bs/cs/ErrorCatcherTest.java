package edu.bs.cs;

import edu.bsu.cs.model.ErrorCatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorCatcherTest {
    @Test
    public void testStatusResponse(){
        int statusCode = 450;
        ErrorCatcher ec = new ErrorCatcher();
        String response = ec.statusError(statusCode);
        Assertions.assertEquals("Unknown status code: 450", response);

    }

    @Test
    public void testSearchNotFound(){
        ErrorCatcher ec = new ErrorCatcher();
        String response = String.valueOf(ec.statusError(400));

        Assertions.assertEquals("Bad Request - The request could not be understood by the server due to malformed syntax. The message body will contain more information; see Response Schema.", response);
    }
}


