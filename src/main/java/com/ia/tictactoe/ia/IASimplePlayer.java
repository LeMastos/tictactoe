package com.ia.tictactoe.ia;

import com.ia.tictactoe.board.Board;
import javafx.util.Pair;

public class IASimplePlayer implements IAPlayer {

    // Moves {row, col} in order of preferences. {0, 0} at top-left corner
    private final static int[][] preferredMoves = {
            {1, 1}, // Center
            {0, 0}, // Top-left
            {0, 2}, // Top-right
            {2, 0}, // Bottom-left
            {2, 2}, // Bottom-right
            {0, 1}, // Top
            {1, 0}, // Left
            {1, 2}, // Right
            {2, 1}  // Bottom
    };

    private Board board;

    public IASimplePlayer(Board board) {
        this.board = board;
    }

    @Override
    public Pair<Integer, Integer> bestMove() {
        for (int[] move : preferredMoves) {
            if (board.isEmptyCell(move[0], move[1])) {
                return new Pair<>(move[0], move[1]);
            }
        }
        return null;
    }
}
