package PrimeFactorization;

/**
 * PrimeFactorization
 */
public class PrimeFactorization {
    public static void main(String[] args) {
        int n = 1090518034;
        System.out.println(fact(n));
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