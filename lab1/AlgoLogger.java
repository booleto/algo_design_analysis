import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Random;

import javax.naming.spi.DirStateFactory.Result;
/**
 * AlgoLogger
 */
public class AlgoLogger {
    public static void main(String[] args) throws IOException {        
        FileWriter logfile;
        BufferedWriter log;
        Random rd = new Random();
        int n = 1000;
        int runs_per_ex = 20;
        long start, end;
        long[] result = new long[runs_per_ex];

        logfile = new FileWriter("log.txt");
        log = new BufferedWriter(logfile);

        //ex1
        log.write("Ex1:\n");
        log.write("Execution time: ");

        for (int i = 0; i < runs_per_ex; i++) {
            int arr[] = getRandomArr(n, rd);
            start = System.nanoTime();
            example1(arr);
            end = System.nanoTime();

            result[i] = end - start;
            log.write(Long.toString(result[i]) + " ");
        }
        log.newLine();
        log.write("Average: ");
        log.write(Long.toString(avg(result)));
        log.newLine();log.newLine();
        log.flush();

        //ex2
        log.write("Ex2:\n");
        log.write("Execution time: ");

        for (int i = 0; i < runs_per_ex; i++) {
            int arr[] = getRandomArr(n, rd);
            start = System.nanoTime();
            example2(arr);
            end = System.nanoTime();

            result[i] = end - start;
            log.write(Long.toString(result[i]) + " ");
        }
        log.newLine();
        log.write("Average: ");
        log.write(Long.toString(avg(result)));
        log.newLine();log.newLine();
        log.flush();

        //ex3
        log.write("Ex3:\n");
        log.write("Execution time: ");

        for (int i = 0; i < runs_per_ex; i++) {
            int arr[] = getRandomArr(n, rd);
            start = System.nanoTime();
            example3(arr);
            end = System.nanoTime();

            result[i] = end - start;
            log.write(Long.toString(result[i]) + " ");
        }
        log.newLine();
        log.write("Average: ");
        log.write(Long.toString(avg(result)));
        log.newLine();log.newLine();
        log.flush();

        //ex4
        log.write("Ex4:\n");
        log.write("Execution time: ");

        for (int i = 0; i < runs_per_ex; i++) {
            int arr[] = getRandomArr(n, rd);
            start = System.nanoTime();
            example4(arr);
            end = System.nanoTime();

            result[i] = end - start;
            log.write(Long.toString(result[i]) + " ");
        }
        log.newLine();
        log.write("Average: ");
        log.write(Long.toString(avg(result)));
        log.newLine();log.newLine();
        log.flush();

        //ex5
        log.write("Ex5:\n");
        log.write("Execution time: ");

        for (int i = 0; i < runs_per_ex; i++) {
            int first[] = getRandomArr(n, rd);
            int second[] = getRandomArr(n, rd);
            start = System.nanoTime();
            example5(first, second);
            end = System.nanoTime();

            result[i] = end - start;
            log.write(Long.toString(result[i]) + " ");
        }
        log.newLine();
        log.write("Average: ");
        log.write(Long.toString(avg(result)));
        log.newLine();log.newLine();
        log.flush();
    }

    public static long avg(long[] arr) {
        long result = 0;
        for (long l : arr) {
            result += l;
        }
        result /= arr.length;
        return result;
    }

    public static int[] getRandomArr(int n, Random rd) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }

        return arr;
    }

    public static int example1 (int[] arr) {
        int n = arr.length;
        int total = 0;
        for ( int j =0; j < n ; j ++) { // loop from 0 to n -1
            total += arr[j];
        }
        return total;
    }

    public static int example2 (int[ ] arr ) {
        int n = arr.length;
        int total = 0;
        for ( int j =0; j < n ; j += 2) // note the increment of 2
            total += arr[j];
        return total;
    }

    public static int example3 (int[] arr) {
        int n = arr.length; 
        int total = 0;
        for ( int j =0; j < n ; j ++) // loop from 0 to n -1
            for ( int k =0; k <= j ; k ++) // loop from 0 to j
                total += arr [j];
        return total ;
    }

    public static int example4 (int[ ] arr ) {
        int n = arr.length, prefix = 0, total = 0;
        for ( int j =0; j < n ; j ++) { // loop from 0 to n -1
            prefix += arr [ j ];
            total += prefix ;
        }
        return total;
    }

    public static int example5 (int[ ] first , int[ ] second ) {
        // assume equal - length arrays
        int n = first . length , count = 0;
        for ( int i =0; i < n ; i ++) { // loop from 0 to n -1
            int total = 0;
            for ( int j =0; j < n ; j ++) // loop from 0 to n -1
                for ( int k =0; k <= j ; k ++) // loop from 0 to j
                    total += first [ k ];
            if ( second [ i ] == total ) count ++;
        }
        return count;
    }
}