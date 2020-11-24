package Algorithms.Sort;

public class SelectionSort {

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Select the i-th largest element from the back part.
    private static void sort(int[] a) {
        int n = a.length;
        int min;
        for(int i = 0; i < n - 1; i++) {
            min = i;
            for(int j = i + 1; j < n; j++)
                if (a[j] < a[min]) min = j;
            exch(a, i, min);
        }
    }

    private static void printArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] a = {4,1,7,6,2,3,1};
        sort(a);
        printArray(a);
    }
}
