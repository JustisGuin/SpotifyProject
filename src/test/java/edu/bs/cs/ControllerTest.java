package edu.bs.cs;


import edu.bsu.cs.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import java.util.Scanner;

import static edu.bsu.cs.Controller.spotifyInput;

public class ControllerTest {
    @Test
    public void getControllerInput(){

        Controller controllerInput = new Controller();

        String spotifyAPIOutPut = controllerInput.spotifyInput(new Scanner(System.in));

        Assertions.assertEquals(result);
    }


}
