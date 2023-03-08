package BinaryRepresentation;

public class BinaryRepresentation {
    public static void main(String[] args) {
        int n = 238423478;
        System.out.println(bin(n));
    }

    static String bin(int n) {
        if (n <= 1) {
            return Integer.toString(n);
        }
        return bin(n / 2) + (n % 2);
    }
}
