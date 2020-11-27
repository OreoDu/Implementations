package Algorithms.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class QuickSort {
    private static final int CUTOFF = 10;

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static int medianOf3(Comparable[] a, int lo, int mid, int hi) {
        if (less(a[hi],a[lo])) exch(a, lo, hi);
        if (less(a[mid],a[lo])) exch(a, mid, lo);
        if (less(a[hi],a[mid])) exch(a, mid, hi);
        return mid;
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        // shuffling is needed for performance guarantee
        List tmp = Arrays.asList(a);
        Collections.shuffle(tmp);
        tmp.toArray(a);
        sort(a, 0 , a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo + CUTOFF -1) {
            InsertionSort.sort(a, lo, hi);
            return;
        }

        if (hi <= lo) return;
        int m = medianOf3(a, lo, (lo + hi)/2, hi);
        exch(a, lo, m);

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void printArray(Comparable[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Comparable[] a = {1,2,3,4,5};
        sort(a);
        printArray(a);
    }
}