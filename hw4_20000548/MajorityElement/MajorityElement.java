package MajorityElement;

import java.util.Random;

/**
 * MajorityElement
 */
public class MajorityElement {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr;
        for (int i = 10; i < 100000; i+=434) {
            arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = rd.nextInt();
            }
            System.out.println(majorElement(arr, 0, arr.length - 1));
        }
    }

    static int majorElement(int[] arr, int idx_left, int idx_right) {
        if (idx_left == idx_right) {
            return arr[idx_left];
        }
        int mid = (idx_right - idx_left) / 2 + idx_left;
        int left_major = majorElement(arr, idx_left, mid);
        int right_major = majorElement(arr, mid + 1, idx_right);

        if (left_major == right_major) {
            return left_major;
        }

        int left_major_count = countElement(arr, left_major, idx_left, idx_right);
        int right_major_count = countElement(arr, right_major, idx_left, idx_right);

        return (left_major_count > right_major_count) ? left_major : right_major;
    }

    static int countElement(int[] arr, int elem, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == elem) {
                count++;
            }
        }
        return count;
    }
}