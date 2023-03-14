package BinaryRepresentation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class BinaryRepresentation {
    public static void main(String[] args) throws IOException{
        FileWriter logfile = new FileWriter("log_bin.txt");;
        BufferedWriter log = new BufferedWriter(logfile);;
        long start, end;
        
        for (int i = 1; i < 10000000; i+= 1000) {
            start = System.nanoTime();
            System.out.println(bin(i));
            end = System.nanoTime();
            log.write(Long.toString(end - start));
            log.newLine();
        }
        log.flush();
    }

    static String bin(int n) {
        if (n <= 1) {
            return Integer.toString(n);
        }
        return bin(n / 2) + (n % 2);
    }
}
