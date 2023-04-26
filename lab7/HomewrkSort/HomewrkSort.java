package HomewrkSort;

/**
 * BubbleSort
 */
public class HomewrkSort {
    public static void main(String[] args) {
        System.out.println(selectionSort("HOMEWRK"));
        System.out.println(bubbleSort("HOMEWRK"));
    }

    //Bài 2
    static String selectionSort(String str) {    
        StringBuilder arr = new StringBuilder(str);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int temp = 0;
            for (int j = 0; j < arr.length(); j++) {
                if (arr.charAt(j) < arr.charAt(temp)) {
                    temp = j;
                }
            }
            result.append(arr.charAt(temp));
            arr.deleteCharAt(temp);
        }
        return result.toString();
    }

    //Bài 3
    static String bubbleSort(String str) {
        StringBuilder arr = new StringBuilder(str);
        char temp;
        for (int i = 0; i < arr.length(); i++) {
            for (int j = i; j < arr.length(); j++) {
                if (arr.charAt(i) > arr.charAt(j)) {
                    temp = arr.charAt(i);
                    arr.setCharAt(i, arr.charAt(j));
                    arr.setCharAt(j, temp);
                }
            }
        }
        return arr.toString();
    }
}