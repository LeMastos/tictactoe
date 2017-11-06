package com.ia.tictactoe;

import com.ia.tictactoe.board.Board;
import com.ia.tictactoe.board.impl.ArrayBoard;

public class Game {

    enum State {
        PLAYING, PLAYER_X_WON, PLAYER_O_WON, DRAW
    }

    private Board board;
    private Player currentPlayer;
    private State currentState;

    public Game(int cells) {
        this.board = new ArrayBoard(cells);
        this.currentPlayer = Player.X;
        this.currentState = State.PLAYING;
    }

    public void play(int row, int col) {
        if (currentState == State.PLAYING) {
            if (board.isEmptyCell(row, col)) {
                board.move(currentPlayer, row, col);

                if (board.hasAWinner()) {
                    switch (currentPlayer) {
                        case X: currentState = State.PLAYER_X_WON; break;
                        case O: currentState = State.PLAYER_O_WON; break;
                    }
                } else {
                    if (board.isFull()) {
                        currentState = State.DRAW;
                    }
                    currentPlayer = _switchPlayer();
                }
            } else {
                System.out.println("It is not an empty cell");
            }
        }
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void printBoard() {
        System.out.println();
        System.out.println("\t 0   1   2 ");
        System.out.println("\t----------");
        board.print();
        System.out.println("\t----------");
        System.out.println();
    }

    public Board getBoard() {
        return board;
    }

    private Player _switchPlayer() {
        switch (currentPlayer) {
            case X:
                return Player.O;
            case O:
                return Player.X;
        }
        throw new IllegalStateException("should not be happened");
    }
}
