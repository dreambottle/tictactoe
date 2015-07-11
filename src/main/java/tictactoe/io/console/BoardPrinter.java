package tictactoe.io.console;

import tictactoe.game.board.Board;

import java.io.IOException;
import java.io.Writer;

public class BoardPrinter {

    private final Writer writer;
    private final char[] playerSymbols;

    public BoardPrinter(Writer writer) {
        this.writer = writer;

        playerSymbols = new char[]{'x', 'o'};
    }

    public void print(Board board) {
        int vSize = board.getVSize();
        int hSize = board.getHSize();
        int[] playerMarks = board.getAllMarks();

        try {

            writer.append("-------------\n");
            for (int i = 0; i < vSize; i++) {
                for (int j = 0; j < hSize; j++) {
                    int markIdx = i * hSize + j;

                    int playerId = playerMarks[markIdx];
                    char playerMark = getSymbolForPlayer(playerId);

                    writer.append("| ").append(playerMark).append(" ");
                }
                writer.append("|\n");
                writer.append("-------------\n");
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private char getSymbolForPlayer(int playerId) {
        if (playerId >= 0 && playerId < playerSymbols.length) {
            return playerSymbols[playerId];
        } else {
            return ' ';
        }
    }
}
