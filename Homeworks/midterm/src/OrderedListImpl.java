public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {
    private int capacity;
    private ONode<E> head;

    public OrderedListImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        head = null;
    }

    public int size() {
        ONode<E> temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public E getMin() {
        E val = null;
        if(head != null) {
            val = head.data;
        }
        return val;
    }

    @Override
    public E getMax() {
        E val = null;
        ONode<E> temp = head;
        while(temp != null) {
            val = temp.data;
            temp = temp.next;
        }
        return val;
    }

    private void insert(E val) {
        ONode<E> node = new ONode<E>(val, null);
        ONode<E> temp = head;
        if (temp == null) {
            head = node;
            return;
        }
        while(temp != null) {
            if(temp.data <= val && (temp.next == null || temp.next.data > val)) {
                node.next = temp.next;
                temp.next = node;
            } else if (temp.data > val) {
                node.next = temp;
                head = node;
            }
            temp = temp.next;
        }

    }

    private void remove(E val) {
        ONode<E> temp = head;
        if (temp == null) {
            return;
        }
        while(temp != null) {
            if(temp.next != null && temp.next.data == val) {
                temp.next = temp.next.next;
                return;
            } else if (temp.data == val) {
                head = temp.next;
                return;
            }
            temp = temp.next;
        }
    }

    @Override
    public void add(E val) {
        if (capacity == 0) {
            return;
        } else if(size() < capacity) {
            insert(val);
        } else if (val > getMin()) {
            insert(val);
            remove(getMin());
        } else {
            // do nothing
        }
    }

    @Override
    public OrderedList merge(OrderedList other) {
        //TODO compare implementation types
        //OrderedList result = new OrderedListImpl(this.capacity + other.capacity);
        //ONode<E> temp1 = this.head;
        //ONode<E> temp2 =

        //return result;
        return null;
    }

    @Override
    public void resize(int newCapacity) {
        while(size() > newCapacity) {
            remove(getMin());
        }
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        String result = "[";
        ONode<E> temp = head;
        int count = 0;
        while(temp != null) {
            if(count < capacity-1) {
                result += temp.data + " ";
            } else {
                result += temp.data;
            }
            temp = temp.next;
            count++;
        }
        while(count < capacity-1) {
            result += "? ";
            count++;
        }
        if(count == capacity-1) {
            result += "?";
        }
        result += "]";
        return result;
    }
}
