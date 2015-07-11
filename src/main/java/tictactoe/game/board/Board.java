package tictactoe.game.board;

import java.util.Collection;

public interface Board {

    int getSize();

    boolean hasWinningCombination();

    int[] getAllPositions();

//    Collection<Integer> getPlayerPositionIndices(int playerId);


}
