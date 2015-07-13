package tictactoe.game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int[][] board;

    public Board() {
        clear();
    }

    public Board copy() {
        try {
            return (Board) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getPlayerAt(int x, int y) {
        return board[x][y];
    }

    public void setPlayerAt(int x, int y, int playerId) {
        board[x][y] = playerId;
    }

    public int getPlayerAt(Position p) {
        return board[p.getX()][p.getY()];
    }

    public void setPlayerAt(Position p, int playerId) {
        board[p.getX()][p.getY()] = playerId;
    }

    public boolean isTie() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) return false;
            }
        }

        return true;
    }

    public boolean isWon(int playerId, Position lastMove) {
        return ((board[0][lastMove.getY()] == playerId
                && board[1][lastMove.getY()] == playerId
                && board[2][lastMove.getY()] == playerId)

                || (board[lastMove.getX()][0] == playerId
                && board[lastMove.getX()][1] == playerId
                && board[lastMove.getX()][2] == playerId)

                || (board[0][0] == playerId
                && board[1][1] == playerId
                && board[2][2] == playerId)

                || (board[2][0] == playerId
                && board[1][1] == playerId
                && board[0][2] == playerId)
        );
    }

    public List<Position> getPossibleMoves() {
        List<Position> positions = new ArrayList<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == -1) {
                    positions.add(new Position(x, y));
                }
            }
        }
        return positions;
    }

    private void clear() {
        board = new int[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}
        };
    }
}
