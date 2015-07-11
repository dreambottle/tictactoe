package tictactoe;

import tictactoe.config.GameConfig;
import tictactoe.config.OpponentMode;
import tictactoe.game.board.Board3x3;
import tictactoe.io.console.BoardPrinter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {

    public static void main(String[] args) {
        GameConfig gameConfig = GameConfig.getInstance();

        // TODO read from input
        gameConfig.setOpponentMode(OpponentMode.PVP);


        Board3x3 board3x3 = new Board3x3();
        BoardPrinter boardPrinter = new BoardPrinter(new OutputStreamWriter(System.out));
        boardPrinter.print(board3x3);
    }
}
