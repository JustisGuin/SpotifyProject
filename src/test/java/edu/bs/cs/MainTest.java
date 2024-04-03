package edu.bs.cs;

import edu.bsu.cs.Main;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void testMainMethod() {
        ByteArrayInputStream in = new ByteArrayInputStream("User input here".getBytes());
        System.setIn(in);

        try {
            Main.main(new String[]{});
        } catch (IOException | InterruptedException e) {
            fail("Exception occurred: " + e.getMessage());
        }

        assertEquals("", outContent.toString().trim());
    }

}
