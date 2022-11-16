package lesson11;

import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 6};
        int[] sorted = bubbleSort(arr);


        int sortedLength = sorted.length;
        System.out.println("Initial array: " + Arrays.toString(arr));
        for (int j : sorted) System.out.print(j + " ");

        System.out.println();
        // array already sorted
        int index = binarySearch(arr, 0, arr.length - 1, 6);
        System.out.printf("Element %d has index: %d", 6, index);
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;
    }

    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }
}
