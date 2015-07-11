package tictactoe;

import tictactoe.config.GameConfig;
import tictactoe.config.OpponentMode;

public class Main {

    public static void main(String[] args) {
        GameConfig gameConfig = GameConfig.getInstance();

        // TODO read from input
        gameConfig.setOpponentMode(OpponentMode.PVP);


    }
}
