package tictactoe.io.console;


import tictactoe.game.Player;
import tictactoe.game.Position;
import tictactoe.game.board.Board;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanConsolePlayer implements Player {

    private final Scanner scanner;
    private String name;
    private Board board;

    public HumanConsolePlayer(String name, Board board) {
        this.name = name;
        this.board = board;

        scanner = new Scanner(System.in);
    }

    @Override
    public Position getNextMove() {
        System.out.println(name + ", please make your move:");
        int x, y;
        while (true) {
            try {
                System.out.print("x y:");
                x = scanner.nextInt();
                y = scanner.nextInt();

                // TODO check input range
                break;
            } catch (InputMismatchException e) {
                System.out.println("bad input, try again.");
            }
        }

        return new Position(x, y);
    }
}
