package PrimeFactorization;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 * PrimeFactorization
 */
public class PrimeFactorization {
    public static void main(String[] args) throws IOException {
        FileWriter logfile = new FileWriter("log_fact.txt");;
        BufferedWriter log = new BufferedWriter(logfile);;
        long start, end;
        
        for (int i = 1; i < 10000000; i+= 1000) {
            start = System.nanoTime();
            System.out.println(fact(i));
            end = System.nanoTime();
            log.write(Long.toString(end - start));
            log.newLine();
        }
        log.flush();
    }

    static String fact(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i + " * " + fact(n / i);
            }
        }
        return Integer.toString(n);
    }
}