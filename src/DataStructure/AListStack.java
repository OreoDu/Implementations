package DataStructure;

public class AListStack<T> {
    private int size = 0;
    static final int REFACTOR = 2;
    private T[] items;

    public AListStack(){
        items =(T[]) new Object[10];
    }

    private void resize(int capacity) {
        T[] n =(T[]) new Object[capacity];
        System.arraycopy(items,0,n,0,size);
        items = n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() { return size;}

    public void push(T x){
        if (items.length == size) resize(size*REFACTOR);
        items[size++] = x;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("The stack is empty.");
            return null;
        } else {
            double r = (double) size / items.length;
            if (r < 0.25) resize(items.length / 2);
            T returnValue = items[size - 1];
            items[--size] = null;
            return returnValue;
        }
    }
}
