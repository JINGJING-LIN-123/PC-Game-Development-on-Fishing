import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class Vector3DTest {
    private Vector3D vector = new Vector3D(1.0, 1.0, 1.0);

    // Timeout rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Before
    public void myTestSetUp() throws Exception {
        vector = new Vector3D(1.0,1.0, 1.0);
    }

    @Test
    public void getx() throws Exception {
        assertEquals(1.0, vector.getX(), 1e-6);
    }
    @Test
    public void gety() throws Exception {
        assertEquals(1.0, vector.getY(), 1e-6);
    }
    @Test
    public void getz() throws Exception {
        assertEquals(1.0, vector.getZ(), 1e-6);
    }

    @Test
    public void tostring() throws Exception {
        assertEquals("(1.00,1.00,1.00)",vector.toString());
    }

    @Test
    public void getMagnitude() throws Exception {
        assertEquals(Math.sqrt(3), vector.getMagnitude(), 1e-6);
    }

    @Test
    public void normalized() throws Exception {
        assertEquals(1/Math.sqrt(3), vector.normalized().getX(), 1e-6);
        assertEquals(1/Math.sqrt(3), vector.normalized().getY(), 1e-6);
        assertEquals(1/Math.sqrt(3), vector.normalized().getZ(), 1e-6);
    }
    @Test(expected = IllegalStateException.class)
    public void normalizedExcepton() throws Exception {
        Vector3D vector2 = new Vector3D(0, 0, 0);
        vector2.normalized();
    }
    @Test
    public void add() throws Exception {
        assertEquals(2.0, vector.add(vector).getX(), 1e-6);
        assertEquals(2.0, vector.add(vector).getY(), 1e-6);
        assertEquals(2.0, vector.add(vector).getZ(), 1e-6);
    }
    @Test
    public void multiply() throws Exception {
        assertEquals(2.0, vector.multiply(2.0).getX(), 1e-6);
        assertEquals(2.0, vector.multiply(2.0).getY(), 1e-6);
        assertEquals(2.0, vector.multiply(2.0).getZ(), 1e-6);
    }
    @Test
    public void dotProduct() throws Exception {
        assertEquals(1.0, vector.dotProduct(vector).getX(), 1e-6);
        assertEquals(1.0, vector.dotProduct(vector).getY(), 1e-6);
        assertEquals(1.0, vector.dotProduct(vector).getZ(), 1e-6);
    }
    @Test
    public void angleBetween() throws Exception {
        Vector3D vector1 = new Vector3D(1, 0, 0);
        Vector3D vector2 = new Vector3D(0, 1, 0);
        assertEquals(90.0, vector1.angleBetween(vector2), 1e-6);
    }
    @Test(expected = IllegalStateException.class)
    public void angleBetweenExcepton() throws Exception {
        Vector3D vector2 = new Vector3D(0, 0, 0);
        vector.angleBetween(vector2);
    }

}

