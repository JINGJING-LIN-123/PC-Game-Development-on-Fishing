import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

//set up
public class RectangleTest {
    private Rectangle rec = new Rectangle(0, 0, 10, 10);

    @Before
    public void myTestSetUp() throws Exception {
        rec = new Rectangle(0, 0, 10, 10);
    }

// test for Negative width and Height
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() throws Exception {
        rec = new Rectangle(0, 0, -2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeight() throws Exception {
        rec = new Rectangle(0, 0, 2, -2);
    }

// test for overlap
    @Test
    public void testOverlap1() throws Exception {
        Rectangle rec2 = new Rectangle(5, 5, 10, 10);
        assertEquals(true, rec.overlap(rec2));
    }

    @Test
    public void testOverlap2() throws Exception {
        Rectangle rec2 = new Rectangle(-10, -10, 20, 20);
        assertEquals(true, rec.overlap(rec2));
    }

    @Test
    public void testOverlap3() throws Exception {
        Rectangle rec2 = new Rectangle(15, 12, 2, 2);
        assertEquals(false, rec.overlap(rec2));
    }

    @Test
    public void testOverlap4() throws Exception {
        Rectangle rec2 = new Rectangle(10, 0, 5, 5);
        assertEquals(false, rec.overlap(rec2));
    }

    // test for intersect
    @Test
    public void testIntersect1() throws Exception {
        Rectangle rec2 = new Rectangle(5, 5, 10, 10);
        assertEquals("x:5, y:5, w:5, h:5", rec.intersect(rec2).toString());
    }

    @Test
    public void testIntersect2() throws Exception {
        Rectangle rec2 = new Rectangle(-10, -10, 20, 20);
        assertEquals("x:0, y:0, w:10, h:10", rec.intersect(rec2).toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIntersect3() throws Exception {
        Rectangle rec2 = new Rectangle(15, 12, 2, 2);
        rec.intersect(rec2);
    }

    //test for union
    @Test
    public void testUnion1() throws Exception {
        Rectangle rec2 = new Rectangle(5, 5, 10, 10);
        assertEquals("x:0, y:0, w:15, h:15", rec.union(rec2).toString());
    }

    @Test
    public void testUnion2() throws Exception {
        Rectangle rec2 = new Rectangle(-10, -10, 20, 20);
        assertEquals("x:-10, y:-10, w:20, h:20", rec.union(rec2).toString());
    }

    @Test
    public void testUnion3() throws Exception {
        Rectangle rec2 = new Rectangle(15, 12, 2, 2);
        assertEquals("x:0, y:0, w:17, h:14", rec.union(rec2).toString());
    }


    //test for toString
    @Test
    public void testToString() throws Exception {
        assertEquals("x:0, y:0, w:10, h:10", rec.toString());
    }

}
