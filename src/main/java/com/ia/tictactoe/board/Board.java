package com.ia.tictactoe.board;

import com.ia.tictactoe.Player;

public interface Board {

    char EMPTY_CELL = '-';

    void move(Player currentPlayer, int row, int col);
    void print();
    boolean isFull();
    boolean isEmptyCell(int row, int col);
    boolean hasAWinner();
}
