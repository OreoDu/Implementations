package DataStructure;

public class SLListStack<T> {

    private static class Node<T> {
        public T item;
        public Node<T> next;
        private Node<T> sentinel;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<T> sentinel;

    public SLListStack() {
        sentinel = new Node<>(null,null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T x) {
        Node<T> n = new Node<>(x,sentinel.next);
        sentinel.next = n;
        size++;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("There is no element in the stack");
            return null;
        }else {
            Node<T> re = sentinel.next;
            sentinel.next = re.next;
            size--;
            return re.item;
        }
    }

    public int size() {
        return size;
    }

}
