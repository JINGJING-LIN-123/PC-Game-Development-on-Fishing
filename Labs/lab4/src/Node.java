public class Node {
    // two things:
    // 1. val -- int
    public String val;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public Node next;

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val;
    }
}
