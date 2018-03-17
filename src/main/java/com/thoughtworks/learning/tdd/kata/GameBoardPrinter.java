package com.thoughtworks.learning.tdd.kata;

public class GameBoardPrinter {
    public String printBoard(String[][] board) {
        StringBuilder sb = new StringBuilder();
        String columnsHeader = createColumnsHeaderFor(board);
        String rowSeparator = createRowSeparatorFor(board);

        sb.append(columnsHeader);

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            sb.append(rowIndex);
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                sb.append(board[rowIndex][columnIndex]).append("|");
            }
            sb.deleteCharAt(sb.length()-1);

            if (rowIndex != board.length-1) {
                sb.append("\n");
                sb.append(rowSeparator);
            }
        }
        return sb.toString();
    }

    private String createColumnsHeaderFor(String[][] board) {
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        for (int i=0; i<board.length; i++) {
            sb.append((char)('A' + i)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");

        return sb.toString();
    }

    private String createRowSeparatorFor(String[][] board) {
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        for (int i=0; i<board.length; i++) {
            sb.append("-+");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");

        return sb.toString();
    }
}
