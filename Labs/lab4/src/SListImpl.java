public class SListImpl implements SList {
    // Only need the head as the member varialbe.
    // As long as I have the head, I'll be able find
    // all the nodes, following the next pointers.
    private Node head;

    // creates an empty linked list
    public SListImpl() {
    }

    // creates a linked list with head n
    public SListImpl(Node n) {
        head = n;
    }

    @Override
    public boolean add(String val) {
        Node n = new Node(val, null);
        Node traversePtr = head;
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

    @Override
    public String get(int index) {
        int counter = 0;
        Node traversePtr = head;

        String val= null;
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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String remove(int index) {
        int counter = 0;
        Node traversePtr = head;
        Node PrePtr = head;
        String val= null;

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

    @Override
    public int size() {
        int counter = 0;
        Node traversePtr = head;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            // increment the counter
            counter++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return counter;
    }

    @Override
    public SList oddWords(){
        SList list = new SListImpl();
        Node traversePtr = head;
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

    @Override
    public SList evenWords(){
        SList list = new SListImpl();
        Node traversePtr = head;
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


    @Override
    public String toString() {
        String res = "";
        Node traversePtr = head;

        while(traversePtr != null) { // we jump out of the loop when we're at the null ptr
            res = res + traversePtr.toString() + " ";
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return res;
    }
}