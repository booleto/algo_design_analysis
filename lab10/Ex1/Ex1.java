package Ex1;


/**
 * Ex1
 */
public class Ex1 {
    //static ArrayList<Integer> memT = new ArrayList<Integer>();
    static Long[] memT = new Long[5000];
    public static void main(String[] args) {
        int n = 4;
        memT[0] = (long) 2;
        memT[1] = (long) 2;

        long start_time = 0;
        long end_time = 0;

        start_time = System.nanoTime();
        System.out.print("Normal T: " + T(n) + " " + T(n + 1) + " " + T(n + 2) + " " + T(n + 3));
        end_time = System.nanoTime();
        System.out.println("\t Execution time: " + (end_time - start_time));

        start_time = System.nanoTime();
        System.out.print("Dynamic T: " + dynamicT(n) + " " + dynamicT(n + 1) + " " + dynamicT(n + 2) + " " + dynamicT(n + 3));
        end_time = System.nanoTime();
        System.out.println("\t Execution time: " + (end_time - start_time));
    }

    static long T(int n) {
        if (n == 0 || n == 1) {
            return 2;
        }

        long result = 0;
        for (int i = 1; i <= n - 1; i++) {
            result +=  2 * T(i) * T(i - 1);
        }
        return result;
    }

    static long dynamicT(int n) {
        if (memT[n] != null) {
            return memT[n];
        }

        long result = 0;
        for (int i = 1; i <= n - 1; i++) {
            result +=  2 * dynamicT(i) * dynamicT(i - 1);
        }
        memT[n] = result;
        return result;
    }
}
