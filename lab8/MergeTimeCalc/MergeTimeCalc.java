package MergeTimeCalc;

import java.util.Random;

/**
 * GreedyMerge
 */
public class MergeTimeCalc {
    public static void main(String[] args) {
        Random rd = new Random(69420);
        Integer[] a = new Integer[100];

        System.out.print("A = [");
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt(100);
            System.out.print(a[i] + " ");
        }
        System.out.println("]");

        System.out.print("Greedy: ");
        System.out.println(greedyMerge(a));
        System.out.print("Divide and conquer: ");
        System.out.println(divAndConquer(a, 0, a.length - 1));
        System.out.print("Combined: ");
        System.out.println(combined(a));
    }

    static long greedyMerge(Integer[] a) {
        long cost = a[0] + a[1];
        for (int i = 2; i < a.length; i++) {
            cost += cost + a[i];
        }
        return cost;
    }

    static long divAndConquer(Integer[] a, int start, int end) {
        if (end - start == 2) {
            return divAndConquer(a, start, end - 1) + a[end];
        }
        if (end - start == 1) {
            return a[end] + a[start];
        }

        return divAndConquer(a, start, (start + end)/2) + divAndConquer(a, (start + end)/2 + 1, end);
    }

    static long combined(Integer[] a) {
        sort(a, 0, a.length - 1);
        return divAndConquer(a, 0, a.length - 1);
    }

    static int partition(Integer arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(Integer arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}