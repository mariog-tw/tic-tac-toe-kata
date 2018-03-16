package com.thoughtworks.learning.tdd.kata;

public class GameBoardPrinter {
    public String printBoard(String[][] board) {
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
}
