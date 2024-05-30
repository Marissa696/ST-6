import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    @DisplayName("Check if player symbols are initialized")
    void checkPlayerSymbolsInitialization() {
        Game game = new Game();
        assertNotNull(game.player1.symbol);
        assertNotNull(game.player2.symbol);
        assertNotEquals(game.player1.symbol, game.player2.symbol);
    }

    @Test
    @DisplayName("Check if game board is initialized with empty cells")
    void checkEmptyBoardInitialization() {
        Game game = new Game();
        for (char cell : game.board) {
            assertEquals(' ', cell);
        }
    }

    @Test
    @DisplayName("Check if board size is correct")
    void checkBoardSize() {
        Game game = new Game();
        assertEquals(9, game.board.length);
    }

    @Test
    @DisplayName("Check if generating moves on a full board returns no moves")
    void checkGenerateMovesOnFullBoard() {
        char[] board = {
                'X', 'O', 'X',
                'O', 'X', 'O',
                'X', 'O', 'X'
        };
        ArrayList<Integer> result = new ArrayList<>();

        Game game = new Game();
        game.generateMoves(board, result);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Check if Minimax algorithm returns a valid move on a random board")
    void checkMinimaxOnRandomBoard() {
        char[] board = {
                'X', ' ', ' ',
                'O', 'X', ' ',
                ' ', ' ', 'O'
        };

        Game game = new Game();
        int move = game.MiniMax(board, game.player1);

        assertTrue(move >= 0 && move < 9);
        assertEquals('X', game.board[move]);
    }

    @Test
    @DisplayName("Check if player can make a move on an empty cell")
    void checkPlayerMoveOnEmptyCell() {
        TicTacToeCell cell = new TicTacToeCell(1, 0, 0);
        assertFalse(cell.getMarker() == 'X' || cell.getMarker() == 'O');
    }

    @Test
    @DisplayName("Check if setting marker changes cell state")
    void checkSettingMarkerChangesCellState() {
        TicTacToeCell cell = new TicTacToeCell(1, 0, 0);
        cell.setMarker("X");
        assertTrue(cell.getMarker() == 'X');
        assertFalse(cell.isEnabled());
    }

    @Test
    @DisplayName("Check if evaluatePosition returns infinity for winning position")
    void checkEvaluatePositionForWinningPosition() {
        char[] board = {
                'X', 'X', 'X',
                'O', 'O', ' ',
                ' ', ' ', ' '
        };

        Game game = new Game();
        game.symbol = 'X';

        assertEquals(Game.INF, game.evaluatePosition(board, game.player1));
    }

    @Test
    @DisplayName("Check if evaluatePosition returns zero for draw position")
    void checkEvaluatePositionForDrawPosition() {
        char[] board = {
                'X', 'O', 'X',
                'X', 'O', 'O',
                'O', 'X', 'X'
        };

        Game game = new Game();

        assertEquals(0, game.evaluatePosition(board, game.player1));
    }

    @Test
    @DisplayName("Check if GameState is PLAYING after player's move")
    void checkGameStateAfterPlayerMove() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        panel.cells[0].doClick();
        assertEquals(State.PLAYING, game.state);
    }
}