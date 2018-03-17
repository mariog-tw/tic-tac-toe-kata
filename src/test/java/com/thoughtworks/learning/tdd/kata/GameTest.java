package com.thoughtworks.learning.tdd.kata;

import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.learning.tdd.kata.Game.*;
import static org.junit.Assert.assertArrayEquals;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = Game.newClassicGame();
    }

    @Test
    public void newGameHasAnEmptyBoard() {
        String[][] emptyBoard = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(emptyBoard, game.board());
    }

    @Test
    public void placeXAtCellA0() {
        game.playIn("A0");

        String[][] boardWithXInA0 = new String[][]{
                {PLAYER_1_SYMBOL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(boardWithXInA0, game.board());
    }

    @Test
    public void placeXAtCellC0() {
        game.playIn("C0");

        String[][] boardWithXInC0 = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, PLAYER_1_SYMBOL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(boardWithXInC0, game.board());
    }

    @Test
    public void placeXAtCellA2AndThenOAtCellB1() {
        game.playIn("A2");
        game.playIn("B1");

        String[][] boardWithXInA2AndOInB1 = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, PLAYER_2_SYMBOL, EMPTY_CELL},
                {PLAYER_1_SYMBOL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(boardWithXInA2AndOInB1, game.board());
    }

    @Test
    public void playingInAnOccupiedCellWillNotChangeTheBoardState() {
        game.playIn("A1");
        game.playIn("B2");
        game.playIn("A1");
        game.playIn("A2");

        String[][] boardWithXInA2AndOInB1 = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {PLAYER_1_SYMBOL, EMPTY_CELL, EMPTY_CELL},
                {PLAYER_1_SYMBOL, PLAYER_2_SYMBOL, EMPTY_CELL}
        };

        assertArrayEquals(boardWithXInA2AndOInB1, game.board());
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

        String[][] wholeGameBoard = new String[][]{
                {PLAYER_1_SYMBOL, PLAYER_2_SYMBOL, PLAYER_1_SYMBOL},
                {PLAYER_2_SYMBOL, PLAYER_1_SYMBOL, PLAYER_2_SYMBOL},
                {PLAYER_1_SYMBOL, PLAYER_2_SYMBOL, PLAYER_1_SYMBOL}
        };

        assertArrayEquals(wholeGameBoard, game.board());
    }

    @Test
    public void testWrongCoordinatesDoNotChangeBoard() {
        game.playIn("ZZ");
        game.playIn("something");
        game.playIn("");
        game.playIn(null);

        String[][] emptyBoard = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(emptyBoard, game.board());
    }

    @Test
    public void coordinatesShouldBeCaseInsensitive() {
        game.playIn("a0");
        game.playIn("B0");
        game.playIn("c1");

        String[][] expectedBoard = new String[][]{
                {PLAYER_1_SYMBOL, PLAYER_2_SYMBOL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, PLAYER_1_SYMBOL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };

        assertArrayEquals(expectedBoard, game.board());
    }

    @Test
    public void boardCanBeAlso4x4() {
        game = Game.newExtendedGame();

        game.playIn("a2");
        game.playIn("d3");

        String[][] expectedBoard = new String[][] {
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {PLAYER_1_SYMBOL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, PLAYER_2_SYMBOL}
        };

        assertArrayEquals(expectedBoard, game.board());
    }
}