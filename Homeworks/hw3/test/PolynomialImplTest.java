/**
 * The class PolynomialImplTest test class PolynomialImpl.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/27/2021
 */

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialImplTest {
    private PolynomialImpl poly = new PolynomialImpl("5x^2 +4x^1 -2");

    @Test
    public void testConstructor() throws Exception {
        assertEquals("5x^2 +4x^1 -2", poly.toString());
    }

    @Test
    public void testConstructor2() throws Exception {
        PolynomialImpl poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
        assertEquals("-2x^5 -3x^4 +11x^1 -5", poly.toString());
    }

    @Test
    public void testaddTerm1() throws Exception {
        poly.addTerm(3, 3);
        assertEquals("3x^3 +5x^2 +4x^1 -2", poly.toString());
    }

    @Test
    public void testaddTerm2() throws Exception {
        poly.addTerm(3, 1);
        assertEquals("5x^2 +7x^1 -2", poly.toString());
    }

    @Test
    public void testaddTerm3() throws Exception {
        poly.addTerm(-4, 1);
        assertEquals("5x^2 -2", poly.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testaddTerm4() throws Exception {
        poly.addTerm(-4, -1);
    }

    @Test
    public void testremoveTerm1() throws Exception {
        poly.removeTerm(1);
        assertEquals("5x^2 -2", poly.toString());
    }

    @Test
    public void testremoveTerm2() throws Exception {
        poly.removeTerm(3);
        assertEquals("5x^2 +4x^1 -2", poly.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testremoveTerm3() throws Exception {
        poly.removeTerm(-1);
    }

    @Test
    public void testgetDegree() throws Exception {
        assertEquals(2, poly.getDregree());
    }

    @Test
    public void testgetCoefficient1() throws Exception {
        assertEquals(5, poly.getCoefficient(2));
        assertEquals(4, poly.getCoefficient(1));
        assertEquals(-2, poly.getCoefficient(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testgetCoefficient2() throws Exception {
        poly.getCoefficient(-1);
    }

    @Test
    public void testevaluate() throws Exception {
        assertEquals(26., poly.evaluate(2), 1e-3);
    }

    @Test
    public void testadd1() throws Exception {
        PolynomialImpl poly2 = new PolynomialImpl("2x^3 +1x^1 +2");
        assertEquals("2x^3 +5x^2 +5x^1", poly.add(poly2).toString());
    }

    @Test
    public void testadd2() throws Exception {
        PolynomialImpl poly2 = new PolynomialImpl("-5x^2 -4x^1 +2");
        assertEquals("", poly.add(poly2).toString());
    }
}
