import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * the class GListImpTest tests TListImp class.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/24/2021
 */
public class GListImpTest {
    private GListImp<Integer> list = new GListImp<Integer>();


    //testoddTs2 method tests TListImp with type int.
    @Test
    public void testGListImp() throws Exception {
        assertTrue(list.isEmpty());
        assertEquals("1 ", list.add(1).toString());
        assertEquals("1 2 ", list.add(2).toString());
        assertEquals("1 2 3 ", list.add(3).toString());
        assertEquals("1 2 3 4 ", list.add(4).toString());
        assertEquals("1 2 3 4 ", list.toString());
        assertEquals(4, list.size());
        assertEquals((Integer)2, list.getVal(1));
        assertFalse(list.isEmpty());
        assertEquals("2 3 4 ", list.getNext().toString());
        assertEquals(2, list.find(3));
        assertEquals("1 3 4 ", list.remove(1).toString());
    }
}



