package Algorithms.Sort;

public class MergeSort {
    private static final int CUTOFF = 7;
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        //assert isSorted(a, lo, mid);
        //assert isSorted(a, mid + 1, hi);
        // copy
        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
        //assert isSorted(a,lo,hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        if (hi <= lo + CUTOFF -1) {
            InsertionSort.sort(a, lo, hi);
            return;
        }

        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if(!less(a[mid + 1],a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void printArray(Comparable[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Comparable[] a = {7,1,2,3,4,2,3};
        sort(a);
        printArray(a);
    }
}