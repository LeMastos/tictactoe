package com.ia.tictactoe;

import com.ia.tictactoe.ia.IAPlayer;
import com.ia.tictactoe.ia.IASimplePlayer;
import javafx.util.Pair;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        System.out.println("Hello, Welcome to TicTacToe !");

        Scanner in = new Scanner(System.in);
        Game game = new Game(3);

        game.printBoard();

        do {
            System.out.print("Player " + game.getCurrentPlayer() + " - Enter your move : ");

            // Manual player
            if (game.getCurrentPlayer() == Player.X) {
                int row = in.nextInt();
                int col = in.nextInt();

                game.play(row, col);

                // IA Player
            } else {
                IAPlayer iaPlayer = new IASimplePlayer(game.getBoard());
                Pair<Integer, Integer> bestMove = iaPlayer.bestMove();

                int row = bestMove.getKey();
                int col = bestMove.getValue();

                game.play(row, col);
                System.out.println();
            }

            game.printBoard();

            switch (game.getCurrentState()) {
                case DRAW: System.out.println("################# It's a Draw ! #################"); break;
                case PLAYER_X_WON: System.out.println("################# Player 'X' has won ! #################"); break;
                case PLAYER_O_WON: System.out.println("################# Player 'O' has won ! #################"); break;
            }

        } while (game.getCurrentState() == Game.State.PLAYING);

    }
}
