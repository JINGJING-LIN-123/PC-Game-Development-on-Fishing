import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class ScientistTest {
    private Scientist sheldon = new Scientist("sheldon", 23, "12345", "54321");


    // Timeout rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Before
    public void myTestSetUp() throws Exception {
        sheldon = new Scientist("sheldon", 23, "12345", "54321");
    }

    @Test
    public void testConstructor1() throws Exception {
        sheldon = new Scientist("sheldon", 23, "12345", "54321");
        assertEquals("sheldon", sheldon.getName());
        assertEquals(23, sheldon.getAge());
        assertEquals("12345", sheldon.getSSN());
        assertEquals("ComputerScience", sheldon.getSpecialty());
    }

    @Test
    public void testConstructor2() throws Exception {
        sheldon = new Scientist("sheldon", 23, "12345", "54321", "professor");
        assertEquals("sheldon", sheldon.getName());
        assertEquals(23, sheldon.getAge());
        assertEquals("12345", sheldon.getSSN());
        assertEquals("professor", sheldon.getSpecialty());
    }

    @Test
    public void testSetter() throws Exception {
        sheldon.setSpecialty("doctor");
        assertEquals("doctor", sheldon.getSpecialty());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetterEmpty() throws Exception {
        sheldon.setSpecialty("");
    }
    @Test
    public void testToString() throws Exception {
        assertEquals("This is Scientist Name: sheldon Specialty: ComputerScience", sheldon.toString());
    }


  }











