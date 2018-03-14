public class Game {
    private static final String EMPTY_CELL = " ";
    private String[][] board = new String[][] {
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
        {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
    };

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
}
