/**
 * The interface TList is linked list interface.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/18/2021
 * @param <T> the data type of val
 */
public interface TList<T> {
    /**
     * The method boolean add is add val to end of list. Any string is OK
     *
     * @param val value from pass in.
     * @return boolean If success is true, if fail is false.
     */
    boolean add(T val); // Add val to end of list. Any String is OK

    /**
     * the method get the value of index node.
     *
     * @param index index is from 0 to n-1.
     * @return T the value of index node.
     */
    T get(int index); // index is from 0 to n-1

    /**
     * the method boolean isEmpty is to test if the list is empty. if yes, return true, other return false.
     *
     * @return boolean return ture if the list is empty, other return false.
     */
    boolean isEmpty();

    /**
     * the method remove removes index node from the list.
     * @param index index is from 0 to n-1.
     * @return T the value of index node.
     */
    T remove(int index); // index is from 0 to n-1

    /**
     * the method size is to count how many nodes.
     *
     * @return int the number of nodes.
     */
    int size();
    // SList oddWords(SList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.

    /**
     * the method oddTs is return a new list or modify the original, either is OK. Position 0 is even, position 1 is odd, etc.
     *
     * @return TList returns list of odd numbered Ts.
     */
    TList<T> oddTs(); // Returns list of odd numbered words only

    // SList evenWords(SList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.

    /**
     * the method evenTs is return a new list or modify the original, either is OK. Position 0 is even, position 1 is odd, etc.
     *
     * @return TList returns list of even numbered Ts.
     */
    TList<T> evenTs(); // Returns list of even numbered words only
}
