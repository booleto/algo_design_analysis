package BinSearch;

import java.util.Random;

public class BinSearch {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, arr[0], arr.length, 30303));
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l && l <= arr.length - 1) {
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
