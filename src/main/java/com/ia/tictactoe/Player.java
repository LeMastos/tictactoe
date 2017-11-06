package com.ia.tictactoe;

public enum Player {
    X('X'), O('O');

    private char value;

    Player(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}