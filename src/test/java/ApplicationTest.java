import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testExitCommand() throws IOException {
        exit.expectSystemExit();
        new Application(new StringReader("exit\n"), System.out);
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

        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                assertEquals(expectedOutPut, outputBuffer.toString());
            }
        });

        new Application(new StringReader("exit\n"), out);
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

        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                assertEquals(expectedOutPut, outputBuffer.toString());
            }
        });

        new Application(new StringReader("A0\nexit\n"), out);
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

        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                assertEquals(expectedOutPut, outputBuffer.toString());
            }
        });

        new Application(new StringReader("B1\nnew\nexit\n"), out);
    }
}