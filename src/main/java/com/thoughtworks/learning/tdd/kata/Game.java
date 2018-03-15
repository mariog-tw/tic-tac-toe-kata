package com.thoughtworks.learning.tdd.kata;

public class Game {
    private static final String EMPTY_CELL = " ";

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

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(" A B C\n");

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            sb.append(rowIndex);
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                sb.append(board[rowIndex][columnIndex]).append("|");
            }
            sb.deleteCharAt(sb.length()-1);

            if (rowIndex != board.length-1) {
                sb.append("\n");
                sb.append(" -+-+-\n");
            }
        }
        return sb.toString();
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
        return cellCoordinates == null || !cellCoordinates.matches("[A-Ca-c]{1}[0-2]{1}");
    }

    private boolean cellIsOccupied(int rowIndex, int colIndex) {
        return !(board[rowIndex][colIndex] == EMPTY_CELL);
    }

    private String getSymbolToPlayBasedOnTurn() {
        String symbolToPlay = isPlay1Turn ? "X" : "O";
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
}
