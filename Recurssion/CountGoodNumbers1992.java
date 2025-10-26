package Recurssion;

public class CountGoodNumbers1992 {

    static final long MOD = 1000000007L;

    public static int countGoodNumbers(long n) {
        long evenDigits = (n + 1) / 2;  // Even positions
        long oddDigits = n / 2;         // Odd positions

        long evenPow = power(5, evenDigits);
        long oddPow = power(4, oddDigits);

        return (int) ((evenPow * oddPow) % MOD);
    }

    public static long power(long x, long n) {
        if (n == 0) return 1;

        long half = power(x, n / 2);
        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * x) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50)); //
    }
}
