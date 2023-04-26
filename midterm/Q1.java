public class Q1 {
    public static int max(double[] a, int n) {
        return binarySearch(a);
    }

    public static void main(String[] args) {
        double[] arr = new double[] {0, 1, 2, 5, 6, 7, 8, 9, 10, 4, 3, 2, 1};
        System.out.println(max(arr, arr.length));
    }

    static int binarySearch(double arr[]) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            double midNumber = arr[mid];
            int quarter1 = (mid - low) / 2;
            int quarter2 = (high - mid) / 2;
            
            if (arr[high] == midNumber){
                return mid;
            }
            if (arr[quarter1] < midNumber){
                low = quarter1 - 1;
            }
            if (arr[quarter2] < midNumber){
                high = quarter2 + 1;
            }
            if (arr[quarter1] > mid) {
                high = mid + 1;
            }
            if (arr[quarter2] > mid) {
                low = mid - 1;
            }
        }
        
        return -1;
    }

    static int findMax(double[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[result]) {
                result = i;
            }
        }
        return result;
    }

}