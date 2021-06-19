/**
 * The class TListImp implements TList interface.
 *
 * @author Jingjing Lin
 * @version 1.0
 * @since 06/18/2021
 * @param <T> the data type of val
 */
public class TListImp<T> implements TList<T> {
    // Only need the head as the member varialbe.
    // As long as I have the head, I'll be able find
    // all the nodes, following the next pointers.
    private TNode<T> head;

    // creates an empty linked list
    public TListImp() {
    }

    // creates a linked list with head n
    public TListImp(TNode<T> n) {
        head = n;
    }
    /**
     * The method boolean add is add val to end of list. Any string is OK
     *
     * @param val value from pass in.
     * @return boolean If success is true, if fail is false.
     */
    @Override
    public boolean add(T val) {
        TNode<T> n=new TNode<T>(val, null);
        TNode<T> traversePtr = head;
        if(isEmpty()) {
            head = n;
        } else {
            while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
                if (traversePtr.next == null) {
                    traversePtr.next = n;
                    break;
                }
                // jump to the next node
                traversePtr = traversePtr.next;
            }
        }
        return true;

    }

    /**
     * the method get the value of index node.
     *
     * @param index index is from 0 to n-1.
     * @return T the value of index node.
     */
    @Override
    public T get(int index) {
        int counter = 0;
        TNode<T> traversePtr = head;

        T val= null;
        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            if(counter == index){
                val = traversePtr.val;
            }
            // increment the counter
            counter++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }
        return val;
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
     * the method remove removes index node from the list.
     * @param index index is from 0 to n-1.
     * @return T the value of index node.
     */
    @Override
    public T remove(int index) {
        int counter = 0;
        TNode<T> traversePtr = head;
        TNode<T> PrePtr = head;
        T val= null;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            if(counter == index){
                 val = traversePtr.val;
                 if (traversePtr == head) {
                     head = traversePtr.next;
                 } else {
                     PrePtr.next = traversePtr.next;
                 }
            }
            // increment the counter
            counter++;
            // jump to the next node
            PrePtr = traversePtr;
            traversePtr = traversePtr.next;
        }
        return val;
    }

    /**
     * the method size is to count how many nodes.
     *
     * @return int the number of nodes.
     */
    @Override
    public int size() {
        int counter = 0;
        TNode<T> traversePtr = head;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            // increment the counter
            counter++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return counter;
    }

    /**
     * the method oddTs is return a new list or modify the original, either is OK. Position 0 is even, position 1 is odd, etc.
     *
     * @return TList returns list of odd numbered Ts.
     */
    @Override
    public TList<T> oddTs(){
        TList<T> list = new TListImp();
        TNode<T> traversePtr = head;
        int count = 0;
        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            if(count % 2 == 1){
                list.add(traversePtr.val);
            }
            // jump to the next node
            traversePtr = traversePtr.next;
            count++;
        }
        return list;
    }

    /**
     * the method evenTs is return a new list or modify the original, either is OK. Position 0 is even, position 1 is odd, etc.
     *
     * @return TList returns list of even numbered Ts.
     */
    @Override
    public TList<T> evenTs(){
        TList<T> list = new TListImp();
        TNode<T> traversePtr = head;
        int count = 0;
        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            if(count % 2 == 0){
                list.add(traversePtr.val);
            }
            // jump to the next node
            traversePtr = traversePtr.next;
            count++;
        }
        return list;
    }

    /**
     * The toString method prints out the values of all nodes.
     *
     * @return val return values of all nodes in a string.
     */
    @Override
    public String toString() {
        String res = "";
        TNode<T> traversePtr = head;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            res = res + traversePtr.toString();
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return res;
    }
}
