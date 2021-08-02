/*
 * This java class tests MarbleSolitaireModelImpl.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 07/12/2021
 */

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import org.junit.*;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import static org.junit.Assert.*;

public class MarbleSolitaireControllerImplTest {
    Readable rd = new StringReader("");
    Appendable ap = new StringBuilder();
    private cs5004.marblesolitaire.model.MarbleSolitaireModelImpl game = new cs5004.marblesolitaire.model.MarbleSolitaireModelImpl();
    private cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl controller = new cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap);

    @Test
    public void testModelConstructor1() throws Exception {
        assertEquals(
                "    o o o    \n" +
                        "    o o o    \n" +
                        "o o o o o o o\n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    ", game.getGameState());
    }

    @Test
    public void testModelConstructor2() throws Exception {
        cs5004.marblesolitaire.model.MarbleSolitaireModelImpl game = new cs5004.marblesolitaire.model.MarbleSolitaireModelImpl(2,2);
        assertEquals(
                "    o o o    \n" +
                        "    o o o    \n" +
                        "o o _ o o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    ", game.getGameState());
    }

    @Test
    public void testModelConstructor3() throws Exception {
        cs5004.marblesolitaire.model.MarbleSolitaireModelImpl game = new cs5004.marblesolitaire.model.MarbleSolitaireModelImpl(5);
        assertEquals(
                "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o _ o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        ", game.getGameState());
    }

    @Test
    public void testModelConstructor4() throws Exception {
        cs5004.marblesolitaire.model.MarbleSolitaireModelImpl game = new cs5004.marblesolitaire.model.MarbleSolitaireModelImpl(5,4,4);
        assertEquals(
                "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "o o o o _ o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "o o o o o o o o o o o o o\n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        \n" +
                        "        o o o o o        ", game.getGameState());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testMove1() throws Exception {
        game.move(2,2, 3, 3);
    }

    @Test
    public void testMove2() throws Exception {
        game.move(1,3,3,3);
        assertEquals(
                "    o o o    \n" +
                        "    o _ o    \n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    ", game.getGameState());
    }

    @Test
    public void testGetScore() throws Exception {
        assertEquals(32, game.getScore());
        game.move(1,3,3,3);
        assertEquals(31, game.getScore());
    }

    @Test
    public void testisGameOver() throws Exception {
        assertEquals(false, game.isGameOver());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testControllerConstructor() throws Exception {
        cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl controller = new cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl(null, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testControllerPlayGame1() throws Exception {
        controller.playGame(null);
    }

    @Test
    public void testControllerPlayGame2() throws Exception {
        Readable rd = new StringReader("2 4 4 4 q");
        Appendable ap = new StringBuilder();
        cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl controller = new cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap);
        controller.playGame(game);
        assertEquals(
                "    o o o    \n" +
                        "    o o o    \n" +
                        "o o o o o o o\n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 32\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "The column number of the position from where a marble is to be moved:\n" +
                        "The row number of the position to where a marble is to be moved:\n" +
                        "The column number of the position to where a marble is to be moved:\n" +
                        "    o o o    \n" +
                        "    o _ o    \n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 31\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "Game quit!\n" +
                        "    o o o    \n" +
                        "    o _ o    \n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 31\n"
                , ap.toString());
    }

    @Test
    public void testControllerPlayGame3() throws Exception {
        Readable rd = new StringReader("4 4 4 4 q");
        Appendable ap = new StringBuilder();
        cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl controller = new cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap);
        controller.playGame(game);
        assertEquals(
                "    o o o    \n" +
                        "    o o o    \n" +
                        "o o o o o o o\n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 32\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "The column number of the position from where a marble is to be moved:\n" +
                        "The row number of the position to where a marble is to be moved:\n" +
                        "The column number of the position to where a marble is to be moved:\n" +
                        "Invalid move. Play again.\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "Game quit!\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "o o o o o o o\n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 32\n"
                , ap.toString());
    }

    @Test
    public void testControllerPlayGame4() throws Exception {
        Readable rd = new StringReader("2 4 4 x -2 4 q");
        Appendable ap = new StringBuilder();
        cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl controller = new cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap);
        controller.playGame(game);
        assertEquals(
                "    o o o    \n" +
                        "    o o o    \n" +
                        "o o o o o o o\n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 32\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "The column number of the position from where a marble is to be moved:\n" +
                        "The row number of the position to where a marble is to be moved:\n" +
                        "The column number of the position to where a marble is to be moved:\n" +
                        "Invalid input. Input again.\n" +
                        "The column number of the position to where a marble is to be moved:\n" +
                        "Invalid input. Input again.\n" +
                        "The column number of the position to where a marble is to be moved:\n" +
                        "    o o o    \n" +
                        "    o _ o    \n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 31\n" +
                        "The row number of the position from where a marble is to be moved:\n" +
                        "Game quit!\n" +
                        "    o o o    \n" +
                        "    o _ o    \n" +
                        "o o o _ o o o\n" +
                        "o o o o o o o\n" +
                        "o o o o o o o\n" +
                        "    o o o    \n" +
                        "    o o o    \n" +
                        "Score: 31\n"
                , ap.toString());
    }
}

