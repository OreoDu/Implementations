package DataStructure;

public class AListQueue<T> {
    private int head;
    private int tail;
    static final int REFACTOR = 2;
    private T[] items;

    public AListQueue() {
        items = (T[]) new Object[10];
        head = 0;
        tail = 0;
    }

    private void resize(int capacity) {
        T[] n = (T[]) new Object[capacity];
        int size = tail-head;
        System.arraycopy(items,0,n,0,size);
        items = n;
        head = 0;
        tail = size;
    }

    public int size() {return tail - head;}

    public boolean isEmpty() {return tail == head;}

    public void enqueue(T x) {
        if (tail == items.length) resize((tail - head)*REFACTOR);
        items[tail++] = x;
    }

    public T dequeue() {
        if (tail == head) {
            System.out.println("The queue is empty.");
            return null;
        } else {
            double r = (double) (tail - head) / items.length;
            if (r < 0.25) resize(items.length / 2);
            T returnValue = items[tail];
            items[tail++] = null;
            return returnValue;
        }
    }
}
