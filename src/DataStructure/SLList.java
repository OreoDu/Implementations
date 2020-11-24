package DataStructure;

public class SLList<T> {

    private static class Node<T> {
        public T item;
        public Node<T> next;

        public Node(T i, Node<T> n) {
            item = i;
            next = n;
        }
    }

    // Invariant: Sentinel (be guaranteed to be true during code execution.)
    private Node<T> sentinel;
    // Cache: size (put aside data to speed up retrieval)
    private int size = 0;

    public SLList() {
        sentinel = new Node<>(null,null);
    }

    public SLList(T x) {
        Node<T> first = new Node<>(x,null);
        sentinel = new Node<>(null,first);
        size++;
    }

    private int size() { return size; }

    public void addFirst(T x) {
        Node<T> n = new Node<>(x,sentinel.next);
        sentinel.next = n;
        size++;
    }

    public T getFirst() {
        if(sentinel.next == null) return null;
        return sentinel.next.item;
    }

    public T removeFirst() {
        if(size == 0) {
            System.out.println("The List is empty");
            return null;
        }else {
            Node<T> re = sentinel.next;
            sentinel.next = sentinel.next.next;
            size--;
            return re.item;
        }
    }

    public void addLast(T x) {
        Node<T> p = sentinel;
        while(p.next != null) p = p.next;
        p.next = new Node<>(x,null);
        size++;
    }

    public void printSLList() {
        Node<T> p = sentinel.next;
        while(p!= null) {
            System.out.print(p.item + "-->");
            p = p.next;
        }
        System.out.println("End of the List.");
    }

    public static void main(String[] args) {
        SLList<Integer> s = new SLList<>(3);
        s.addFirst(2);
        s.addLast(5);
        s.printSLList();
        s.removeFirst();
        s.printSLList();
        System.out.println(s.size());
    }
}