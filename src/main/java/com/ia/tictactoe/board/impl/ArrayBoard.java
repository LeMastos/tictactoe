package com.ia.tictactoe.board.impl;

import com.ia.tictactoe.Player;
import com.ia.tictactoe.board.Board;

public class ArrayBoard implements Board {

    private int cells;
    private char[][] board;

    public ArrayBoard(int cells) {
        this.cells = cells;
        this.board = new char[this.cells][this.cells];
        _initDefault();
    }

    @Override
    public void move(Player currentPlayer, int row, int col) {
        board[row][col] = currentPlayer.getValue();
    }

    @Override
    public void print() {
        for (int row = 0; row < cells; row++) {
            System.out.print(row + "\t");
            for (int col = 0; col < cells; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < cells - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    @Override
    public boolean isFull() {
        boolean full = true;
        for (int row = 0; row < cells; row++) {
            for (int col = 0; col < cells; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return full;
    }

    @Override
    public boolean isEmptyCell(int row, int col) {
        return board[row][col] == EMPTY_CELL;
    }

    @Override
    public boolean hasAWinner() {
        return _hasAWinnerInRow() || _hasAWinnerInCol() || _hasAWinnerInDiag();
    }

    private boolean _hasAWinnerInRow() {
        return (board[0][0] != EMPTY_CELL && board[0][0] == board[0][1] && board[0][1] == board[0][2])
                || (board[1][0] != EMPTY_CELL && board[1][0] == board[1][1] && board[1][1] == board[1][2])
                || (board[2][0] != EMPTY_CELL && board[2][0] == board[2][1] && board[2][1] == board[2][2]);
    }

    private boolean _hasAWinnerInCol() {
        return (board[0][0] != EMPTY_CELL && board[0][0] == board[1][0] && board[1][0] == board[2][0])
                || (board[0][1] != EMPTY_CELL && board[0][1] == board[1][1] && board[1][1] == board[2][1])
                || (board[0][2] != EMPTY_CELL && board[0][2] == board[1][2] && board[1][2] == board[2][2]);
    }

    private boolean _hasAWinnerInDiag() {
        return (board[0][0] != EMPTY_CELL && board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] != EMPTY_CELL && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private void _initDefault() {
        for (int row = 0; row < cells; row++) {
            for (int col = 0; col < cells; col++) {
                board[row][col] = EMPTY_CELL;
            }
        }
    }

}
