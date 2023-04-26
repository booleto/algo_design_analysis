package Ex4;

public class Ex4 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 11, -4, 13, -5, 2};
        System.out.println(mvcs(arr));
        arr = new int[]{1, -3, 4, -2, -1, 6};
        System.out.println(mvcs(arr));
    }

    static int mvcs(int[] arr) {
        int result = 0;
        for (int sublength = 1; sublength < arr.length; sublength++) {
            for (int start = 0; start <= arr.length - sublength; start++) {
                int sub_sum = 0;
                for (int i = start; i < start + sublength; i++) {
                    sub_sum += arr[i];
                }

                if (sub_sum > result) {
                    result = sub_sum;
                }
            }
        }
        return result;
    }

    static int mvcsImprov(int[] arr) {
        int result = 0;
        for (int start = 1; start < arr.length; start++) {
            int sub_sum = 0;
            for (int i = start; i <= arr.length - start; i++) {
                sub_sum += arr[i];

                if (sub_sum > result) {
                    result = sub_sum;
                }
            }
        }
        return result;
    }
}
