/**
 * The class emptyGList implements empty GList interface.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/24/2021
 * @param <G> the data type of val
 */
public class emptyGList<G> implements GList<G> {

    // creates an empty linked list
    public emptyGList() {}

    /**
     * the method gets the head of the GList.
     *
     * @return GNode<G> return the node of the GList.
     */
    @Override
    public GNode<G> getHead() {
        return null;
    }

    /**
     * The method add is add val to end of list.
     *
     * @param val value from pass in.
     * @return GList<G> return the updated GList.
     */
    @Override
    public GList<G> add(G val){ // Add val to end of list.
        GList<G> result = new nonEmptyGList<G>(val);
        return result;
    }

    /**
     * the method size is to count how many nodes.
     *
     * @return int the number of nodes.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * the method get the value of index node.
     *
     * @param index index is from 0 to n-1.
     * @return G the value of index node.
     */
    @Override
    public G getVal(int index){ // index is from 0 to n-1
        throw new IllegalArgumentException();
    }
    /**
     * the method returns the rest of this GList.
     *
     * @return GList<G> the rest of this GList.
     */
    @Override
    public GList<G> getNext() {
        return null;
    }
    /**
     * the method boolean isEmpty is to test if the list is empty. if yes, return true, other return false.
     *
     * @return boolean return ture if the list is empty, other return false.
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     * the method finds the index of val in the GList.
     *
     * @return int the index of val if found, -1 otherwise.
     */
    @Override
    public int find(G val) {
        return -1;
    }

    /**
     * the method remove removes index node from the list.
     * @param index index is from 0 to n-1.
     * @return GList<G> return the resulting GList.
     */
    @Override
    public GList<G> remove(int index){
        throw new IllegalArgumentException();
    } // index is from 0 to n-1

    /**
     * The toString method prints out the values of all nodes.
     *
     * @return val return values of all nodes in a string.
     */
    @Override
    public String toString() {
        return "";
    }
}
