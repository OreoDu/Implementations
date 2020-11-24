package DataStructure;

public class AList<T> {
    private int size = 0;
    private T[] items;
    static final int REFACTOR = 2;

    public AList() {
        items = (T[]) new Object[2];
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
    }

    public int size() { return size;}

    public T get(int i) {
        return items[i];
    }

    public void addLast(T x){
        if (size == items.length) resize(size * REFACTOR);
        items[size++] = x;
    }

    public T removeLast() {
        if (size == 0) {
            System.out.println("The list is empty.");
            return null;
        } else {
            double r = (double) size / items.length;
            if (r < 0.25) resize(items.length / 2);
            T returnValue = items[size - 1];
            items[--size] = null;
            return returnValue;
        }
    }

    public void printAList() {
        if (size == 0) System.out.println("The array is empty.");
        System.out.print("[");
        for (int i = 0; i<size; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.print("]");
    }

    public static void main(String args[]) {
        AList<Integer> a = new AList<>();
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.printAList();
        a.removeLast();
        a.printAList();
    }
}
