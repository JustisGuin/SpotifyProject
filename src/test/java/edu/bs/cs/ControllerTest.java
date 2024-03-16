package edu.bs.cs;


import edu.bsu.cs.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;
import java.io.IOException;
import java.util.Scanner;


public class ControllerTest {
    @Test
    public void getControllerInput() throws IOException, InterruptedException {
        Controller controllerInput = new Controller();

        System.setIn(new java.io.ByteArrayInputStream("".getBytes()));

        String spotifyOutput = controllerInput.spotifyInput();

        Assertions.assertEquals("No entry was entered.\n", spotifyOutput);
    }


}
