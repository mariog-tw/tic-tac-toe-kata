import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGameHasAnEmptyBoard() {
        Game game = Game.newGame();
        String emptyBoard = " A B C\n" +
                            "0 | | \n" +
                            " -+-+-\n" +
                            "1 | | \n" +
                            " -+-+-\n" +
                            "2 | | ";
        assertEquals(emptyBoard, game.printBoard());
    }

}