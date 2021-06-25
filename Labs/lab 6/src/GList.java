/**
 * The interface TList is linked list interface.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/24/2021
 * @param <G> the data type of val
 */
public interface GList <G> {
    /**
     * The method add is add val to end of list.
     *
     * @param val value from pass in.
     * @return GList<G> return the updated GList.
     */
    GList<G> add(G val); // Add val to end of list.

    /**
     * the method size is to count how many nodes.
     *
     * @return int the number of nodes.
     */
    int size();

    /**
     * the method get the value of index node.
     *
     * @param index index is from 0 to n-1.
     * @return G the value of index node.
     */
    G getVal(int index); // index is from 0 to n-1

    /**
     * the method returns the rest of this GList.
     *
     * @return GList<G> the rest of this GList.
     */
    GList<G> getNext();

    /**
     * the method boolean isEmpty is to test if the list is empty. if yes, return true, other return false.
     *
     * @return boolean return ture if the list is empty, other return false.
     */
    boolean isEmpty();

    /**
     * the method finds the index of val in the GList.
     *
     * @return int the index of val if found, -1 otherwise.
     */
    int find(G val);

    /**
     * the method remove removes index node from the list.
     * @param index index is from 0 to n-1.
     * @return GList<G> return the resulting GList.
     */
    GList<G> remove(int index); // index is from 0 to n-1

    /**
     * the method gets the head of the GList.
     *
     * @return GNode<G> return the node of the GList.
     */
    GNode<G> getHead();
}
