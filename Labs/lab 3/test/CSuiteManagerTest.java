
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class CSuiteManagerTest {
    private CSuiteManager amy = new CSuiteManager("amy", 24, "12333", "33321", 3);

    // Timeout rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Before
    public void myTestSetUp() throws Exception {
        amy = new CSuiteManager("amy", 24, "12333", "33321", 3);
    }

    @Test
    public void testConstructor1() throws Exception {
        amy = new CSuiteManager("amy", 24, "12333", "33321", 3, 100, 5.55, "programmer");
        assertEquals("amy", amy.getName());
        assertEquals(24, amy.getAge());
        assertEquals("12333", amy.getSSN());
        assertEquals(3, amy.getNumSubordinates());
        assertEquals(555.00, amy.getCost(), 1e-6);
    }

    @Test
    public void testConstructor2() throws Exception {
        amy = new CSuiteManager("amy", 24, "12333", "33321", 3);
        assertEquals("amy", amy.getName());
        assertEquals(24, amy.getAge());
        assertEquals("12333", amy.getSSN());
        assertEquals(3, amy.getNumSubordinates());
        assertEquals(0.00, amy.getCost(), 1e-6);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("This is CSuiteManager, Name: amy fancyTitle: Chief Technical Officer", amy.toString());
    }

    @Test
    public void testgetCost() throws Exception {
        amy.setStockOptions(200);
        assertEquals(200.00, amy.getCost(),1e-6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetStockOptions() throws Exception {
        amy.setStockOptions(10);
        throw new IllegalArgumentException();
    }

    @Test
    public void testgetCapitalGains() throws Exception {
        amy.setStockOptions(100);
        assertEquals(955.00, amy.getCapitalGains(10.55),1e-6);
    }


}



