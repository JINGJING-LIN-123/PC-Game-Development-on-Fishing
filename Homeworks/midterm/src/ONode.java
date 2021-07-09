public class ONode<E extends Comparable<E>> {
    public E data;
    public ONode<E> next;

    /*
     * Default constructor to create an empty ONode.
     *
     */
    public ONode() {
        data = null;
        next = null;
    }

    public ONode(E data, ONode<E> next) {
        this.data = data;
        this.next = next;
    }
}
