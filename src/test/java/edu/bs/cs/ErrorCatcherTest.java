package edu.bs.cs;

import edu.bsu.cs.ErrorCatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorCatcherTest {
    @Test
    public void testStatusResponse(){
        int statusCode = 450;
        ErrorCatcher ec = new ErrorCatcher();
        String response = ec.statusError(statusCode);
        Assertions.assertEquals("error", response);




    }
}


