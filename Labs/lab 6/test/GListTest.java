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
public class GListTest {
    private GList<Integer> list = new emptyGList<Integer>();
    private GList<Integer> list2 = new nonEmptyGList<Integer>(0);

    //testoddTs2 method tests TListImp with type int.
    @Test
    public void testGListImp() throws Exception {
        assertTrue(list.isEmpty());
        list = list.add(1);
        list = list.add(2);
        list = list.add(3);
        list = list.add(4);
        assertEquals("1 2 3 4 ", list.toString());
        assertEquals(4, list.size());
        assertEquals((Integer)2, list.getVal(1));
        assertFalse(list.isEmpty());
        assertEquals("2 3 4 ", list.getNext().toString());
        assertEquals(2, list.find(3));
        list = list.remove(1);
        assertEquals("1 3 4 ", list.toString());

        assertFalse(list2.isEmpty());
        list2 = list2.add(1);
        list2 = list2.add(2);
        list2 = list2.add(3);
        list2 = list2.add(4);
        assertEquals("0 1 2 3 4 ", list2.toString());
        assertEquals(5, list2.size());
        assertEquals((Integer)1, list2.getVal(1));
        assertEquals("1 2 3 4 ", list2.getNext().toString());
        assertEquals(3, list2.find(3));
        list2 = list2.remove(1);
        assertEquals("0 2 3 4 ", list2.toString());

    }
}



