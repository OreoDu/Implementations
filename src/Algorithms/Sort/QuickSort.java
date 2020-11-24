package Algorithms.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class QuickSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
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
        tmp.toArray();
        sort(a, 0 , a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
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
        Comparable[] a = {7,1,2};
        sort(a);
        printArray(a);
    }
}