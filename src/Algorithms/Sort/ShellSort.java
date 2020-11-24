package Algorithms.Sort;

public class ShellSort {
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(int[] a) {
        int n = a.length;
        // while (h < n/3) h = h*3 + 1;
        for (int h = n/3; h >= 1; h = h/3 ) {
            for (int i = h; i < n ; i++) {
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h)
                    exch(a,j,j-h);
            }
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
        int[] a = {4,1,7,6,2,3,1,12,13,10,22,56,76,23,17,65,23};
        sort(a);
        printArray(a);
    }
}
