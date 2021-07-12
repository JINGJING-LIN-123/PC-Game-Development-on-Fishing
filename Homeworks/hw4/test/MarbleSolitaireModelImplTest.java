/*
 * This java class tests MarbleSolitaireModelImpl.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 07/12/2021
 */

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarbleSolitaireModelImplTest {
    private cs5004.marblesolitaire.model.MarbleSolitaireModelImpl game = new cs5004.marblesolitaire.model.MarbleSolitaireModelImpl();

    @Test
    public void testConstructor1() throws Exception {
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
    public void testConstructor2() throws Exception {
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
    public void testConstructor3() throws Exception {
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
    public void testConstructor4() throws Exception {
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
}
