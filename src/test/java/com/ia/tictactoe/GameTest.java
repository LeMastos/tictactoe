package com.ia.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void init_game() {
        Game game = new Game(3);
        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
        assertThat(game.getCurrentState()).isEqualTo(Game.State.PLAYING);
    }

    @Test
    void play_game() {
        Game game = new Game(3);
        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);

        game.play(0, 1);
        assertThat(game.getCurrentPlayer()).isEqualTo(Player.O);

        game.play(1, 1);
        assertThat(game.getCurrentPlayer()).isEqualTo(Player.X);
    }

    @Test
    void play_game_return_state_DRAW() {
        Game game = new Game(3);

        game.play(0, 0);
        game.play(0, 1);
        game.play(0, 2);
        game.play(1, 2);
        game.play(1, 0);
        game.play(2, 0);
        game.play(1, 1);
        game.play(2, 2);
        game.play(2, 1);

        assertThat(game.getCurrentState()).isEqualTo(Game.State.DRAW);
    }

    @Test
    void play_game_winner_is_X_row() {
        Game game = new Game(3);

        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);

        assertThat(game.getCurrentState()).isEqualTo(Game.State.PLAYER_X_WON);
    }

    @Test
    void play_game_winner_is_O_col() {
        Game game = new Game(3);

        game.play(0, 2);
        game.play(0, 0);
        game.play(2, 1);
        game.play(1, 0);
        game.play(1, 1);
        game.play(2, 0);

        assertThat(game.getCurrentState()).isEqualTo(Game.State.PLAYER_O_WON);
    }

    @Test
    void play_game_winner_is_X_diag() {
        Game game = new Game(3);

        game.play(0, 0);
        game.play(1, 0);
        game.play(1, 1);
        game.play(2, 1);
        game.play(2, 2);

        assertThat(game.getCurrentState()).isEqualTo(Game.State.PLAYER_X_WON);
    }
}