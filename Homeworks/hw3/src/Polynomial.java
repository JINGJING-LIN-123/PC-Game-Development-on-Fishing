/**
 * The interface Polynomial is an interface for the polynomial object.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/27/2021
 */
public interface Polynomial {

    /*
     * This method takes a coefficient and a power (both integral numbers) and adds the resulting term to the polynomial.
     *
     * @param coefficient The coefficient of the input term.
     * @param power The power of the input term.
     */
    void addTerm(int coefficient, int power);

    /*
     * This method takes a power and removes any and all terms in the polynomial with that power.
     *
     * @param power The power of the term to remove from the polynomial.
     */
    void removeTerm(int power);

    /*
     * This method returns the degree of this polynomial.
     *
     * @return int Return the degree of this polynomial.
     */
    int getDregree();

    /*
     * This method takes a power and returns the coefficient for the term with that power.
     *
     * @param power The power of the term to get coefficient from.
     * @return int Return the coefficient of the term.
     */
    int getCoefficient(int power);

    /*
     * This method takes a double-precision decimal number and returns a double-precision result.
     *
     * @param number The input double-precision number to evaluate.
     * @return double Return the evaluation result.
     */
    double evaluate(double number);

    /*
     * This method takes another Polynomial object and returns the polynomial obtained by adding the two polynomials.
     *
     * @param other The other polynomial to add with.
     * @return Polynomial The resulting polynomial by adding two polynomials.
     */
    Polynomial add(Polynomial other);
}
