/*Kevin Paul, 4B, 9/24/19*/

public class RingBuffer<E> {
    private int capacity, first, last, size = 0;
    private Object[] array;

    public RingBuffer(int capacity) {
        this.capacity = capacity;

        array = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(E x) {
        if (isFull())
            throw new IllegalStateException("Attempted to enqueue; RingBuffer full.");
        else {
            array[last] = x;
            if ((last + 1) % capacity == 0)
                last = 0;
            else
                last++;
            size++;
        }
    }

    public E dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Attempted to dequeue; RingBuffer empty.");
        else {
            Object give = array[first];
            if ((first + 1) % capacity == 0)
                first = 0;
            else
                first++;
            size--;
            return (E) give;
        }
    }

    public E peek() {
        return (E) array[first];
    }
}

