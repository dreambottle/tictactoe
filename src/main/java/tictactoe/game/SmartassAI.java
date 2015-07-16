package tictactoe.game;

import java.util.List;

/**
 * Created by nico on 7/13/15.
 */
public class SmartassAI implements Player {

    private final int id;
    private final Board board;
    private final RandomMoveAI randomMoveAI;

    Position[] lookup = {
            new Position(1, 1),
            new Position(0, 0),
            new Position(2, 2),
            new Position(0, 2),
            new Position(2, 0),
    };

    public SmartassAI(int id, Board board) {
        this.id = id;
        this.board = board;

        // fallback
        randomMoveAI = new RandomMoveAI(id, board);
    }

    @Override
    public Position getNextMove() {
        Position move;

        // if there is an immediate winning move, do it
        List<Position> possibleMoves = board.getPossibleMoves();
        move = findWinningMove(id, possibleMoves);

        if (move == null) {
            move = findPriorityDefensiveMove(possibleMoves);
        }

        if (move == null) {
            for (Position p : lookup) {
                if (board.getPlayerAt(p) == -1) {
                    return p;
                }
            }
        }

        if (move == null) {
            move = randomMoveAI.getNextMove();
        }

        return move;
    }

    private Position findPriorityDefensiveMove(List<Position> possibleMoves) {
        int opponentId = 1;
        if (id == 1) opponentId = 2;
        Position p = findWinningMove(opponentId, possibleMoves);
        return p;
    }

    private Position findWinningMove(int playerId, List<Position> possibleMoves) {
        for (Position p : possibleMoves) {
            try {
                board.setPlayerAt(p, playerId);
                if (board.isWon(playerId, p)) {
                    return p;
                }
            } finally {
                // set to empty back again
                board.setPlayerAt(p, -1);
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Smartass CPU" + id;
    }
}
