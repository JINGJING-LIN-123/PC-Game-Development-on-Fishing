/**
 * The class PNode implements a polynomial term with power and coefficient as a linked-list node.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/27/2021
 */
public class PNode {
    public int coefficient;
    public int power;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public PNode next;

    /*
     * Default constructor to create an empty PNode.
     *
     */
    public PNode() {
        coefficient = 0;
        power = 0;
        next = null;
    }

    /*
     * A constructor for PNode with input parameters.
     *
     * @param coefficient Input coefficient.
     * @param power Input power.
     * @param next Input pointer for next PNode.
     */
    public PNode(int coefficient, int power, PNode next) {
        this.coefficient = coefficient;
        this.power = power;
        this.next = next;
    }

}
