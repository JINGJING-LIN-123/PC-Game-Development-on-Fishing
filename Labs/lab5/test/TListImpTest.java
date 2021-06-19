import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * the class TListImpTest tests TListImp class.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/18/2021
 */
public class TListImpTest {
    private TListImp<String> list = new TListImp<String>();
    private TListImp<Integer> list2 = new TListImp<Integer>();

    //testoddTs method tests TListImp with type String.
    @Test
    public void testoddTs() throws Exception {
        list.add("java");
        list.add("is");
        list.add("really");
        list.add("hard!");
        assertEquals("is hard! ", list.oddTs().toString());
    }

    //testoddTs2 method tests TListImp with type int.
    @Test
    public void testoddTs2() throws Exception {
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        assertEquals("2 4 ", list2.oddTs().toString());
    }
}



