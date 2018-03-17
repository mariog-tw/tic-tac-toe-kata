package com.thoughtworks.learning.tdd.kata;

import java.util.Arrays;

public class Game {
    static final String EMPTY_CELL = " ";
    static final String PLAYER_1_SYMBOL = "X";
    static final String PLAYER_2_SYMBOL = "O";

    private String[][] board;

    private boolean isPlay1Turn = true;

    private Game(int dimension) {
        board = new String[dimension][dimension];
        for (String[] row : board) {
            Arrays.fill(row, EMPTY_CELL);
        }
    }

    public static Game newClassicGame() {
        return new Game(3);
    }

    public static Game newExtendedGame() {
        return new Game(4);
    }

    public void playIn(String cellCoordinates) {
        if (cellCoordinatesAreInValidFormat(cellCoordinates)) return;

        int colIndex = getColIndexFromCoordinates(cellCoordinates);
        int rowIndex = getRowIndexFromCoordinates(cellCoordinates);

        if (cellIsOccupied(rowIndex, colIndex)) return;

        String symbolToPlay = getSymbolToPlayBasedOnTurn();

        board[rowIndex][colIndex] = symbolToPlay;
    }

    private boolean cellCoordinatesAreInValidFormat(String cellCoordinates) {
        String validCoordinatesRegexp = (board.length == 3)
                ? "[A-Ca-c][0-2]{1}"
                : "[A-Da-d][0-3]{1}";
        return cellCoordinates == null || !cellCoordinates.matches(validCoordinatesRegexp);
    }

    private boolean cellIsOccupied(int rowIndex, int colIndex) {
        return !(board[rowIndex][colIndex].equals(EMPTY_CELL));
    }

    private String getSymbolToPlayBasedOnTurn() {
        String symbolToPlay = isPlay1Turn ? PLAYER_1_SYMBOL : PLAYER_2_SYMBOL;
        isPlay1Turn = !isPlay1Turn;
        return symbolToPlay;
    }

    private int getRowIndexFromCoordinates(String cellCoordinates) {
        return Integer.parseInt(String.valueOf(cellCoordinates.toCharArray()[1]));
    }

    private int getColIndexFromCoordinates(String cellCoordinates) {
        char columnChar = cellCoordinates.toUpperCase().toCharArray()[0];
        return columnChar - 'A';
    }

    String[][] board() {
        return board.clone();
    }
}
