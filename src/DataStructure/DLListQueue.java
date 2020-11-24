package DataStructure;

public class DLListQueue<T> {

    private static class Node<T>{
        public T item;
        public Node<T> next;
        public Node<T> pre;

        public Node(Node<T> pre, T item, Node<T> next) {
            this.pre  = pre;
            this.next = next;
            this.item = item;
        }
    }

    private int size = 0;
    private Node<T> sentinel;

    public DLListQueue() {
        sentinel = new Node<>(null, null, null);
    }

    public int size() {return size;}

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T x) {
        Node<T> n = new Node<>(sentinel, x, sentinel.next);
        sentinel.next = n;
        n.next.pre = n;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            System.out.println("The queue is empty!");
            return null;
        }else {
            Node<T> returnValue = sentinel.pre;
            returnValue.pre.next = sentinel;
            sentinel.pre = returnValue.pre;
            size--;
            return returnValue.item;
        }
    }
}
