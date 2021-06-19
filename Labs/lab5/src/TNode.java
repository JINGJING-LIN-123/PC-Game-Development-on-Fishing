/**
 * The TNode class implements a class that contain one value and a next pointer. The class is generic in term of the data type of the value.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/18/2021
 * @param <T> the data type of val
 */
public class TNode<T> {
    // two things:
    // 1. val -- int
    public T val;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public TNode<T> next;

    /**
     * The TNode is a constructor of TNode class. It pass in the value and the next pointer.
     *
     * @param val value from pass in.
     * @param next  pointer to the next node.
     */
    public TNode(T val, TNode<T> next) {
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
