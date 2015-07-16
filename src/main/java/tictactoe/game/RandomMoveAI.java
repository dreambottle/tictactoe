package tictactoe.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMoveAI implements Player {

    private final int id;
    private final Board board;
    private final Random random;

    public RandomMoveAI(int id, Board board) {
        this.id = id;
        this.board = board;
        random = new Random();
    }

    @Override
    public Position getNextMove() {
        List<Position> positions = board.getPossibleMoves();

        if (positions.size() == 0) return null;

        return positions.get(random.nextInt(positions.size()));
    }


    @Override
    public String getName() {
        return "Dumb CPU" + id;
    }
}
