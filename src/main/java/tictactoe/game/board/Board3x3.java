package tictactoe.game.board;

public class Board3x3 implements Board {

    int[] marks = new int[9];

    public Board3x3() {
        clear();
    }

    @Override
    public int getHSize() {
        return 3;
    }

    @Override
    public int getVSize() {
        return 3;
    }

    @Override
    public boolean hasWinningCombination() {
        // TODO
        return false;
    }

    @Override
    public int[] getAllMarks() {
        return marks;
    }

    @Override
    public boolean putMark(int playerId, int position) {
        if (position < 0 || position >= marks.length
                || playerId < 0 || marks[position] != -1) {
            return false;
        }

        marks[position] = playerId;
        return true;
    }

    private void clear() {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = -1;
        }
    }
}
