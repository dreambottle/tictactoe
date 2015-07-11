package tictactoe.config;

public class GameConfig {
    private static GameConfig instance = new GameConfig();

    public static GameConfig getInstance() {
        return instance;
    }

    private int fieldSize = 3;
    private OpponentMode opponentMode;

    private GameConfig() {
    }


    public OpponentMode getOpponentMode() {
        return opponentMode;
    }

    public void setOpponentMode(OpponentMode opponentMode) {
        this.opponentMode = opponentMode;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }
}
