import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = Game.newGame();
    }

    @Test
    public void newGameHasAnEmptyBoard() {
        String emptyBoard = " A B C\n" +
                            "0 | | \n" +
                            " -+-+-\n" +
                            "1 | | \n" +
                            " -+-+-\n" +
                            "2 | | ";

        assertEquals(emptyBoard, game.printBoard());
    }

    @Test
    public void placeXAtCellA0() {
        game.playIn("A0");

        String expectedBoard =  " A B C\n" +
                                "0X| | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | ";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void placeXAtCellC0() {
        game.playIn("C0");

        String expectedBoard =  " A B C\n" +
                                "0 | |X\n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | ";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void placeXAtCellA2AndThenOAtCellB1() {
        game.playIn("A2");
        game.playIn("B1");

        String expectedBoard =  " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 |O| \n" +
                                " -+-+-\n" +
                                "2X| | ";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void playingInAnOccupiedCellWillNotChangeTheBoardState() {
        game.playIn("A1");
        game.playIn("B2");
        game.playIn("A1");
        game.playIn("A2");

        String expectedBoard =  " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1X| | \n" +
                                " -+-+-\n" +
                                "2X|O| ";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void afterPlayingAWholeGameNothingWillChangeWithOtherPlays() {
        game.playIn("A0");
        game.playIn("A1");
        game.playIn("A2");
        game.playIn("B0");
        game.playIn("B1");
        game.playIn("B2");
        game.playIn("C0");
        game.playIn("C1");
        game.playIn("C2");

        game.playIn("A1");
        game.playIn("A1");

        String expectedBoard =  " A B C\n" +
                                "0X|O|X\n" +
                                " -+-+-\n" +
                                "1O|X|O\n" +
                                " -+-+-\n" +
                                "2X|O|X";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void testWrongCoordinatesDoNotChangeBoard() {
        game.playIn("ZZ");
        game.playIn("something");
        game.playIn("");
        game.playIn(null);

        String expectedBoard =  " A B C\n" +
                                "0 | | \n" +
                                " -+-+-\n" +
                                "1 | | \n" +
                                " -+-+-\n" +
                                "2 | | ";

        assertEquals(expectedBoard, game.printBoard());
    }

    @Test
    public void coordinatesShouldBeCaseInsensitive() {
        game.playIn("a0");
        game.playIn("B0");
        game.playIn("c1");

        String expectedBoard =  " A B C\n" +
                                "0X|O| \n" +
                                " -+-+-\n" +
                                "1 | |X\n" +
                                " -+-+-\n" +
                                "2 | | ";

        assertEquals(expectedBoard, game.printBoard());
    }
}