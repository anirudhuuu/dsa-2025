package basics.maths;

/**
 * You are given an integer n. You need to find out the number of
 * prime numbers in the range [1, n] (inclusive). Return the number of
 * prime numbers in the range.
 * <p>
 * A prime number is a number which has no divisors except, 1 and itself.
 */
public class CountNPrimes {
    /* boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    } */
    // More optimised
    boolean isPrime(int n) {
        // Edge case
        if (n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time Complexity: O(n * √n)
     * Space Complexity: O(1)
     */
    int primeUptoN(int n) {
        int noOfPrimes = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                noOfPrimes += 1;
            }
        }

        return noOfPrimes;
    }
}
