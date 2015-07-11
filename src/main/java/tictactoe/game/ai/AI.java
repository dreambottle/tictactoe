package tictactoe.game.ai;

import tictactoe.game.board.Board;

public interface AI<B extends Board> {

    void setBoard(B board);

    int getNextMove();
}
