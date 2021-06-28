/**
 * The class PolynomialImpl implements interface Polynomial.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/27/2021
 */
public class PolynomialImpl implements Polynomial {
    private PNode head = null;

    /*
     * Default constructor to create an empty Polynomial.
     *
     */
    public PolynomialImpl() {}

    /*
     * The constructor takes a polynomial as a string, parses it and creates the polynomial accordingly.
     *
     * @param The input string for polynomial initialization.
     */
    public PolynomialImpl(String s) {
        for(String sub_s: s.split(" ")) {
            String[] digits = sub_s.replaceAll("\\+", "").split("x\\^");
            if(digits.length == 2) {
                addTerm(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
            } else if(digits.length == 1) {
                addTerm(Integer.parseInt(digits[0]), 0);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /*
     * This method takes a coefficient and a power (both integral numbers) and adds the resulting term to the polynomial.
     *
     * @param coefficient The coefficient of the input term.
     * @param power The power of the input term.
     */
    @Override
    public void addTerm(int coefficient, int power) {
        if(power < 0) {
            throw new IllegalArgumentException();
        }
        if(coefficient == 0) {
            return;
        }
        PNode n = new PNode(coefficient, power, null);
        if(head == null) {
            head = n;
        } else {
            PNode traversePtr = head;
            PNode PrePtr = head;
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                if (traversePtr.power == power) {
                    traversePtr.coefficient += coefficient;
                    if (traversePtr.coefficient == 0) {
                        removeTerm(power);
                    }
                    return;
                } else if (traversePtr.power < power) {
                    n.next = traversePtr;
                    if (traversePtr == head) {
                        head = n;
                    } else {
                        PrePtr.next = n;
                    }
                    return;
                }
                // jump to the next node
                PrePtr = traversePtr;
                traversePtr = traversePtr.next;
            }
            PrePtr.next = n;
        }
    }

    /*
     * This method takes a power and removes any and all terms in the polynomial with that power.
     *
     * @param power The power of the term to remove from the polynomial.
     */
    @Override
    public void removeTerm(int power) {
        if(power < 0) {
            throw new IllegalArgumentException();
        }
        if(head != null) {
            PNode traversePtr = head;
            PNode PrePtr = head;
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                if (traversePtr.power == power) {
                    if (traversePtr == head) {
                        head = head.next;
                    } else {
                        PrePtr.next = traversePtr.next;
                    }
                }
                // jump to the next node
                PrePtr = traversePtr;
                traversePtr = traversePtr.next;
            }
        }
    }

    /*
     * This method returns the degree of this polynomial.
     *
     * @return int Return the degree of this polynomial.
     */
    @Override
    public int getDregree() {
        if (head == null) {
            return -1;
        } else {
            return head.power;
        }
    }

    /*
     * This method takes a power and returns the coefficient for the term with that power.
     *
     * @param power The power of the term to get coefficient from.
     * @return int Return the coefficient of the term.
     */
    @Override
    public int getCoefficient(int power) {
        if(power < 0) {
            throw new IllegalArgumentException();
        }
        if(head == null) {
            return 0;
        } else {
            PNode traversePtr = head;
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                if (traversePtr.power == power) {
                    return traversePtr.coefficient;
                }
                // jump to the next node
                traversePtr = traversePtr.next;
            }
        }
        return 0;
    }

    /*
     * This method takes a double-precision decimal number and returns a double-precision result.
     *
     * @param number The input double-precision number to evaluate.
     * @return double Return the evaluation result.
     */
    @Override
    public double evaluate(double number) {
        double result = 0.0;
        if(head != null) {
            PNode traversePtr = head;
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                result += traversePtr.coefficient * Math.pow(number, Double.valueOf(traversePtr.power));
                // jump to the next node
                traversePtr = traversePtr.next;
            }
        }
        return result;
    }

    /*
     * This method takes another Polynomial object and returns the polynomial obtained by adding the two polynomials.
     *
     * @param other The other polynomial to add with.
     * @return Polynomial The resulting polynomial by adding two polynomials.
     */
    @Override
    public Polynomial add(Polynomial other) {
        Polynomial p_result = new PolynomialImpl(toString());

        for(int i=0; i<=other.getDregree(); i++) {
            int coefficient = other.getCoefficient(i);
            if(coefficient != 0) {
                p_result.addTerm(coefficient, i);
            }
        }
        return p_result;
    }

    /*
     * This method return the polynomial as a string.
     *
     * @return String Return the polynomial as a string.
     */
    @Override
    public String toString() {
        String s = "";
        if(head != null) {
            PNode traversePtr = head;
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                if(traversePtr != head && traversePtr.coefficient > 0) {
                    s += "+";
                }
                if(traversePtr.power > 0) {
                    s += traversePtr.coefficient + "x^" + traversePtr.power;
                } else {
                    s += traversePtr.coefficient;
                }
                if(traversePtr.next != null) {
                    s += " ";
                }
                // jump to the next node
                traversePtr = traversePtr.next;
            }
        }
        return s;
    }
}
