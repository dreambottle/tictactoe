package tictactoe.game;

import tictactoe.game.board.Board3x3;

public class GameManager {
    enum State {
        Player1Turn, Player2Turn,
    }

    public void start() {
        System.out.println("Game Started.");

        Board3x3 board = new Board3x3();
//        state = "";
    }


}
