import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
    @Test
    void testInitialState() {
        Game game = new Game();
        assertEquals(State.PLAYING, game.state);
    }

    @Test
    void testPlayerMove() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        panel.cells[0].doClick();
        assertEquals('X', panel.cells[0].getMarker());
    }

    @Test
    void testXWins() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("X");
        panel.cells[2].setMarker("X");
        assertEquals(State.XWIN, game.checkState(panel.cells));
    }

    @Test
    void testOWins() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        panel.cells[3].setMarker("O");
        panel.cells[4].setMarker("O");
        panel.cells[5].setMarker("O");
        assertEquals(State.OWIN, game.checkState(panel.cells));
    }

    @Test
    void testDraw() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("O");
        panel.cells[2].setMarker("X");
        panel.cells[3].setMarker("O");
        panel.cells[4].setMarker("X");
        panel.cells[5].setMarker("X");
        panel.cells[6].setMarker("X");
        panel.cells[7].setMarker("X");
        panel.cells[8].setMarker("O");
        assertEquals(State.DRAW, game.checkState(panel.cells));
    }

    @Test
    void testMinimaxAlgorithm() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        assertEquals(5, game.MiniMax(panel.cells, game.player2));
    }

    @Test
    void testPlayerChange() {
        Game game = new Game();
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        assertEquals(game.player1, game.cplayer);
        panel.cells[0].doClick();
        assertEquals(game.player2, game.cplayer);
    }
}