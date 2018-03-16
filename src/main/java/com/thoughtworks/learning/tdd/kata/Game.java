package com.thoughtworks.learning.tdd.kata;

public class Game {
    static final String EMPTY_CELL = " ";
    static final String PLAYER_1_SYMBOL = "X";
    static final String PLAYER_2_SYMBOL = "O";

    private String[][] board = new String[][] {
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
    };

    private boolean isPlay1Turn = true;

    private Game() {}

    public static Game newGame() {
        return new Game();
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
        return cellCoordinates == null || !cellCoordinates.matches("[A-Ca-c][0-2]{1}");
    }

    private boolean cellIsOccupied(int rowIndex, int colIndex) {
        return !(board[rowIndex][colIndex] == EMPTY_CELL);
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
        int colIndex = 0;
        switch (cellCoordinates.toUpperCase().toCharArray()[0]) {
            case 'A':
                colIndex = 0;
                break;
            case 'B':
                colIndex = 1;
                break;
            case 'C':
                colIndex = 2;
                break;
        }
        return colIndex;
    }

    String[][] board() {
        return board.clone();
    }
}
