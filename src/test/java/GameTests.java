package com.Marissa696;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    private static Game game;

    @BeforeAll
    private static void initializeGame() {
        game = new Game();
    }

    @Test
    @DisplayName("O Win test")
    public void checkOWin() {
        char[] board = {
            'O', ' ', ' ',
            ' ', 'O', ' ',
            'X', 'X', 'O'
        };

        assertEquals(game.checkState(board), State.OWIN);
    }

    @Test
    @DisplayName("Evaluate X Win position test")
    public void checkEvaluateXWinPosition() {
        char[] board = {
            'X', ' ', ' ',
            ' ', 'X', ' ',
            ' ', ' ', 'X'
        };

        assertEquals(game.evaluatePosition(board, game.player1), Game.INF);
    }    

    @Test
    @DisplayName("Init test")
    public void checkInitStates() {
        assertEquals(game.state, State.PLAYING);
        assertEquals(game.player1.symbol, 'X');
        assertEquals(game.player2.symbol, 'O');
        assertEquals(game.board.length, 9);
    }

    @Test
    @DisplayName("Evaluate Draw position test")
    public void checkEvaluateDrawPosition() {
        char[] board = {
            'X', 'O', 'X',
            'X', 'X', 'O',
            'O', 'X', 'O'
        };

        assertEquals(game.evaluatePosition(board, game.player1), 0);
    }

    @Test
    @DisplayName("Full moves test")
    public void checkGenerateFullMoves() {
        char[] board = {
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '
        };
        ArrayList<Integer> result = new ArrayList<>();

        game.generateMoves(board, result);

        for (int i = 0; i < 9; i++) {
            assertEquals(i, result.get(i));
        }
    }

    @Test
    @DisplayName("X Win test")
    public void checkXWin() {
        char[] board = {
            'X', 'O', 'O',
            ' ', 'X', ' ',
            ' ', ' ', 'X'
        };

        assertEquals(game.checkState(board), State.XWIN);
    }

    @Test
    @DisplayName("Draw test")
    public void checkDraw() {
        char[] board = {
            'X', 'O', 'X',
            'X', 'X', 'O',
            'O', 'X', 'O'
        };

        assertEquals(game.checkState(board), State.DRAW);
    }

    @Test
    @DisplayName("MiniMax test")
    public void checkMiniMax() {
        char[] board = {
            'X', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', 'O'
        };

        assertEquals(game.MiniMax(board, game.player2), 2);
    }
}