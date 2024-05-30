import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    void testXWinsHorizontal() {
        char[] board = {'X', 'X', 'X', 'O', 'O', ' ', ' ', ' ', ' '};
        Game game = new Game();
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void testXWinsVertical() {
        char[] board = {'X', 'O', ' ', 'X', 'O', ' ', 'X', ' ', ' '};
        Game game = new Game();
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void testXWinsDiagonal() {
        char[] board = {'X', 'O', ' ', 'O', 'X', ' ', ' ', ' ', 'X'};
        Game game = new Game();
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void testOWinsHorizontal() {
        char[] board = {'X', 'X', ' ', 'O', 'O', 'O', 'X', ' ', ' '};
        Game game = new Game();
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void testOWinsVertical() {
        char[] board = {'X', 'O', ' ', 'X', 'O', ' ', ' ', 'O', ' '};
        Game game = new Game();
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void testOWinsDiagonal() {
        char[] board = {'O', 'X', ' ', 'X', 'O', ' ', ' ', ' ', 'O'};
        Game game = new Game();
        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void testDraw() {
        char[] board = {'X', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O'};
        Game game = new Game();
        assertEquals(State.DRAW, game.checkState(board));
    }

    @Test
    void testNextMoveSelection() {
        char[] board = {'X', ' ', 'O', ' ', 'X', 'O', 'X', 'O', 'X'};
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(board, moves);
        assertEquals(1, moves.size());
        assertEquals(2, moves.get(0).intValue());
    }

    @Test
    void testAvailableMovesGeneration() {
        char[] board = {'X', ' ', 'O', ' ', 'X', 'O', 'X', 'O', 'X'};
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(board, moves);
        assertEquals(1, moves.size());
        assertEquals(2, moves.get(0).intValue());
    }

    @Test
    void testGameCompletionAfterXWins() {
        char[] board = {'X', ' ', 'O', 'X', 'X', ' ', 'O', ' ', ' '};
        Game game = new Game();
        assertEquals(State.PLAYING, game.checkState(board));
        board[6] = 'X';
        assertEquals(State.XWIN, game.checkState(board));
    }
}