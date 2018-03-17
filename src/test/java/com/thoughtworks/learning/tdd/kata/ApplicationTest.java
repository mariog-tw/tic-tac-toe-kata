package com.thoughtworks.learning.tdd.kata;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ApplicationTest {
    @Test
    public void testExitCommand() throws IOException {
        Application application = new Application(new StringReader("exit\n"), System.out);
        assertFalse(application.isRunning());
    }

    @Test
    public void startingApplicationShowsAFreshBoard() throws IOException {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        String expectedOutPut = " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: ";

        new Application(new StringReader("exit\n"), out);

        assertEquals(expectedOutPut, outputBuffer.toString());
    }

    @Test
    public void makeASinglePlay() throws IOException {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        String expectedOutPut = " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C\n" +
                                "0X| | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: ";

        new Application(new StringReader("A0\nexit\n"), out);

        assertEquals(expectedOutPut, outputBuffer.toString());
    }

    @Test
    public void issueNewGameCommand() throws IOException {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        String expectedOutPut = " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 |X| \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: ";

        new Application(new StringReader("B1\nnew\nexit\n"), out);

        assertEquals(expectedOutPut, outputBuffer.toString());
    }

    @Test
    public void testNewExtendedGameApplication() throws IOException {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputBuffer);
        String expectedOutPut = " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C D\n" +
                                "0 | | | \n" +
                                " -+-+-+-\n" +
                                "1 | | | \n" +
                                " -+-+-+-\n" +
                                "2 | | | \n" +
                                " -+-+-+-\n" +
                                "3 | | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C D\n" +
                                "0 | | | \n" +
                                " -+-+-+-\n" +
                                "1 |X| | \n" +
                                " -+-+-+-\n" +
                                "2 | | | \n" +
                                " -+-+-+-\n" +
                                "3 | | | \n" +
                                "Command: " +
                                "\n\n" +
                                " A B C D\n" +
                                "0 | | | \n" +
                                " -+-+-+-\n" +
                                "1 |X| | \n" +
                                " -+-+-+-\n" +
                                "2 | | | \n" +
                                " -+-+-+-\n" +
                                "3 | | |O\n" +
                                "Command: ";

        new Application(new StringReader("new 4\nB1\nD3\nexit\n"), out);
        assertEquals(expectedOutPut, outputBuffer.toString());
    }
}