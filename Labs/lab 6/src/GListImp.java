/**
 * The class GListImp implements GList interface.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/24/2021
 * @param <G> the data type of val
 */
public class GListImp<G> implements GList<G> {
    // Only need the head as the member varialbe.
    // As long as I have the head, I'll be able find
    // all the nodes, following the next pointers.
    public GNode<G> head;

    // creates an empty linked list
    public GListImp() {
        head = null;
    }

    // creates a linked list with head n
    public GListImp(G val) {
        GNode<G> n = new GNode<G>(val, null);
        head = n;
    }

    // creates a linked list as a copy
    public GListImp(GListImp<G> list) {
        this.head = list.getHead();
    }

    /**
     * the method gets the head of the GList.
     *
     * @return GNode<G> return the node of the GList.
     */
    @Override
    public GNode<G> getHead() {
        return head;
    }

    /**
     * The method add is add val to end of list.
     *
     * @param val value from pass in.
     * @return GList<G> return the updated GList.
     */
    @Override
    public GList<G> add(G val){ // Add val to end of list.
        GNode<G> n=new GNode<G>(val, null);
        if(isEmpty()) {
            head = n;
        } else if (head.next == null) {
            head.next = n;
        } else {
            getNext().add(val);
        }
        return this;

    }

    /**
     * the method size is to count how many nodes.
     *
     * @return int the number of nodes.
     */
    @Override
    public int size() {
        if(isEmpty()) {
            return 0;
        } else {
            return getNext().size() + 1;
        }
    }

    /**
     * the method get the value of index node.
     *
     * @param index index is from 0 to n-1.
     * @return G the value of index node.
     */
    @Override
    public G getVal(int index){ // index is from 0 to n-1
        if(index <0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return head.val;
        } else {
            return getNext().getVal(index-1);
        }
    }
    /**
     * the method returns the rest of this GList.
     *
     * @return GList<G> the rest of this GList.
     */
    @Override
    public GList<G> getNext() {
        if(isEmpty()) {
            return null;
        } else {
            GListImp<G> list = new GListImp<G>(this);
            list.head = list.head.next;
            return list;
        }
    }
    /**
     * the method boolean isEmpty is to test if the list is empty. if yes, return true, other return false.
     *
     * @return boolean return ture if the list is empty, other return false.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * the method finds the index of val in the GList.
     *
     * @return int the index of val if found, -1 otherwise.
     */
    @Override
    public int find(G val) {
        if(isEmpty()) {
            return -1;
        } else if (val == head.val) {
            return 0;
        } else {
            int index = getNext().find(val);
            if (index >= 0) {
                return index+1;
            } else {
                return index;
            }
        }
    }

    /**
     * the method remove removes index node from the list.
     * @param index index is from 0 to n-1.
     * @return GList<G> return the resulting GList.
     */
    @Override
    public GList<G> remove(int index){
        if(index <0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return this;
        } else if (index == 0) {
            head = head.next;
            return this;
        } else {
            GList<G> list = getNext().remove(index-1);
            head.next = list.getHead();
            return this;
        }
    } // index is from 0 to n-1

    /**
     * The toString method prints out the values of all nodes.
     *
     * @return val return values of all nodes in a string.
     */
    @Override
    public String toString() {
        String res = "";
        GNode<G> traversePtr = head;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            res = res + traversePtr.toString();
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return res;
    }
}
