package basics.maths;

/**
 * You are given an integer n. You need to find out the number of
 * prime numbers in the range [1, n] (inclusive). Return the number of
 * prime numbers in the range.
 * <p>
 * A prime number is a number which has no divisors except, 1 and itself.
 */
public class CountNPrimes {
    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int primeUptoN(int n) {
        int noOfPrimes = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                noOfPrimes += 1;
            }
        }

        return noOfPrimes;
    }
}
