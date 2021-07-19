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

    public int getCapacity() {
        return capacity;
    }

    public ONode<E> getHead() {
        return head;
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
            if(temp.data.compareTo(val) <= 0 && (temp.next == null || temp.next.data.compareTo(val) > 0)) {
                node.next = temp.next;
                temp.next = node;
                return;
            } else if (temp.data.compareTo(val) > 0) {
                node.next = temp;
                head = node;
                return;
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
            if(temp.next != null && temp.next.data.compareTo(val) == 0) {
                temp.next = temp.next.next;
                return;
            } else if (temp.data.compareTo(val) == 0) {
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
        } else if (val.compareTo(getMin()) > 0) {
            insert(val);
            remove(getMin());
        } else {
            // do nothing
        }
    }

    @Override
    public OrderedList merge(OrderedList other) {
        OrderedListImpl<E> otherImpl = (OrderedListImpl<E>) other;
        OrderedList result = new OrderedListImpl(this.getCapacity() + otherImpl.getCapacity());
        ONode<E> temp1 = this.getHead();
        ONode<E> temp2 = otherImpl.getHead();

        while(temp1 != null && temp2 != null) {
            if(temp1.data.compareTo(temp2.data) < 0) {
                result.add(temp1.data);
                temp1 = temp1.next;
            } else {
                result.add(temp2.data);
                temp2 = temp2.next;
            }
        }
        while(temp1 != null) {
            result.add(temp1.data);
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            result.add(temp2.data);
            temp2 = temp2.next;
        }
        return result;
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

