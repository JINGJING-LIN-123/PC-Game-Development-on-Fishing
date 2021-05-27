import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PetRockTest {
    private PetRock rocky = new PetRock("Rocky", 1);

    // Timeout rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Before
    public void myTestSetUp() throws Exception {
        rocky = new PetRock("Rocky", 1);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnHappyToStart() throws Exception {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() throws Exception{
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);

    }

    @Test
    public void testFavNum() throws Exception {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyNameFail() throws Exception {
        new PetRock("", 1);
    }

    @Test(timeout = 100) // in ms
    public void waitForHappyTimeout() throws Exception {
        rocky.waitTillHappy();
    }

    @Test
    public void testMass() throws Exception {
        assertEquals(1, rocky.getMass());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Rocky 1", rocky.toString());
    }



    @Test (expected = IllegalStateException.class)
    public void testUnHappy() throws Exception {
        rocky.getHappyMessage();
    }
}