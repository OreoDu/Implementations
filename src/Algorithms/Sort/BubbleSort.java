package Algorithms.Sort;

public class BubbleSort {

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]) exch(a, j, j+1);
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
        int[] a = {4,1,7,6,2,3,1};
        sort(a);
        printArray(a);
    }
}
