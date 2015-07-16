package tictactoe.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Scanner scanner;
    private final String name;
    private final Board board;

    public HumanPlayer(String name, Scanner scanner, Board board) {
        this.scanner = scanner;
        this.name = name;
        this.board = board;
    }

    @Override
    public Position getNextMove() {

        System.out.println(name + ", please make your move:");
        int x, y;
        while (true) {
            try {
                System.out.print("x y: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;

                if (x < 0 || x >= board.getXSize() || y < 0 || y >= board.getYSize()) {
                    System.out.println("Out of range. Range: [1 - " + board.getXSize() + "] [1 - " + board.getYSize() + "]");
                    continue;
                }
                if (board.getPlayerAt(x, y) != -1) {
                    System.out.println("This cell is occupied.");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input, try again.");
            }
        }

        return new Position(x, y);
    }

    @Override
    public String getName() {
        return name;
    }
}
