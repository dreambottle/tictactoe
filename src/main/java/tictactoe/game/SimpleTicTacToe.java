package tictactoe.game;

import java.util.Scanner;

public class SimpleTicTacToe {

    enum State {
        GAME_IN_PROGRESS, WON, TIE
    }


    private final Scanner scanner;
    //    private int[][] board;
    private Board board;
    private int currentPlayerId = 1;
    private boolean quit = false;
    private State state;

    public SimpleTicTacToe() {
        scanner = new Scanner(System.in);
        board = new Board();
//        clearBoard();
        start();
    }

//    private void clearBoard() {
//        board = new int[][]{
//                {-1, -1, -1},
//                {-1, -1, -1},
//                {-1, -1, -1}
//        };
//    }

    private void start() {
        System.out.println("Game started");

        Player p1 = selectPlayer(1);
        Player p2 = selectPlayer(2);

        state = State.GAME_IN_PROGRESS;
        currentPlayerId = 1;

        while (!quit) {
            printBoard();
            Player currentPlayer = currentPlayerId == 1 ? p1 : p2;
            System.out.println(currentPlayer.getName() + " turn");
            Position move = currentPlayer.getNextMove();

            board.setPlayerAt(move.getX(), move.getY(), currentPlayerId);

            if (board.isTie()) state = State.TIE;
            if (board.isWon(currentPlayerId, move)) state = State.WON;

            switch (state) {
                case GAME_IN_PROGRESS:
                    if (currentPlayerId == 1) {
                        currentPlayerId = 2;
                    } else {
                        currentPlayerId = 1;
                    }
                    break;
                case WON:
                    System.out.println(currentPlayer.getName() + " has won!");
                    printBoard();
                    quit = true;
                    break;
                case TIE:
                    System.out.println("TIE!");
                    printBoard();
                    quit = true;
                    break;
            }
        }
    }

    private Player selectPlayer(int id) {
        System.out.println("Select player:");
        System.out.println("1 - Human");
        System.out.println("2 - Dumb CPU");
        System.out.println("3 - Smartass CPU");

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                return new HumanPlayer("Player" + id, scanner, 3, 3, board);
            }
            if (choice == 2) {
                return new RandomMoveAI(board);
            }
            if (choice == 3) {
                return new SmartassAI(id, board);
            }
        }
    }

    private void printBoard() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                String symbol = ".";
                int playerId = board.getPlayerAt(x, y);
                if (playerId == 1) {
                    symbol = "X";
                }
                if (playerId == 2) {
                    symbol = "O";
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
