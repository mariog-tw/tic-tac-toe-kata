package com.thoughtworks.learning.tdd.kata;

public class GameBoardPrinter {
    private String[][] board;
    private final String rowSeparator;

    public GameBoardPrinter(String[][] board) {
        this.board = board;
        this.rowSeparator = rowSeparatorFor(board);
    }

    public String printBoard() {
        return headers() + rows();
    }

    private String rows() {
        StringBuilder sb = new StringBuilder();

        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            sb.append(row(rowIndex));
        }

        return sb.toString();
    }

    private String row(int index) {
        StringBuilder sb = new StringBuilder();

        sb.append(index);
        for (int columnIndex = 0; columnIndex < this.board[index].length; columnIndex++) {
            sb.append(this.board[index][columnIndex]).append("|");
        }
        removeLastCharFrom(sb);

        if (!isLastRow(index)) {
            sb.append("\n");
            sb.append(this.rowSeparator);
        }

        return sb.toString();
    }

    private boolean isLastRow(int index) {
        return index == this.board.length-1;
    }

    private void removeLastCharFrom(StringBuilder sb) {
        sb.deleteCharAt(sb.length()-1);
    }

    private String headers() {
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        for (int i = 0; i< this.board.length; i++) {
            sb.append((char)('A' + i)).append(" ");
        }
        removeLastCharFrom(sb);
        sb.append("\n");

        return sb.toString();
    }

    private String rowSeparatorFor(String[][] board) {
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        for (String[] column : board) {
            sb.append("-+");
        }
        removeLastCharFrom(sb);
        sb.append("\n");

        return sb.toString();
    }
}
