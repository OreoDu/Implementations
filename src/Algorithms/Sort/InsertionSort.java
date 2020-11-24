package Algorithms.Sort;

public class InsertionSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for(int i = lo; i <= hi; i++) {
            for(int j = i; j>0; j--) {
                if (less(a[j],a[j-1])) exch(a, j, j-1);
                else break;
            }
        }
    }

    private static void printArray(Comparable[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Comparable[] a = {4,1,7,6,2,3,1};
        sort(a, 0, a.length-1);
        printArray(a);
    }
}
