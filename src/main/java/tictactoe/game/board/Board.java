package tictactoe.game.board;

import tictactoe.game.Position;

public interface Board {

    int getHSize();

    int getVSize();

    boolean hasWinningCombination();

    int[] getAllMarks();

//    Collection<Integer> getPlayerPositionIndices(int playerId);

    boolean putMark(int playerId, Position position);

}
