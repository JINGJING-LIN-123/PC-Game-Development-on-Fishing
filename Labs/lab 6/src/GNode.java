/**
 * The GNode class implements a class that contain one value and a next pointer. The class is generic in term of the data type of the value.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/24/2021
 * @param <G> the data type of val
 */
public class GNode<G> {
    // two things:
    // 1. val -- int
    public G val;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public GNode<G> next;

    /**
     * Default constructor for GNode class.
     *
     */
    public GNode() {
        val = null;
        next = null;
    }

    /**
     * The method is a constructor of GNode class. It pass in the value and the next pointer.
     *
     * @param val value from pass in.
     * @param next  pointer to the next node.
     */
    public GNode(G val, GNode<G> next) {
        this.val = val;
        this.next = next;
    }

    /**
     * The toString method prints out the value.
     *
     * @return val return value.
     */
    @Override
    public String toString() {
        return val + " ";
    }
}
