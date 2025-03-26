package basics.maths;

/**
 * You are given an integer n. You need to check if the number is prime
 * or not. Return true if it is a prime number, otherwise return false.
 * <p>
 * A prime number is a number which has no divisors except 1 and itself.
 */
public class CheckPrimeNumber {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    boolean isPrime(int n) {
        // Edge case
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     */
    boolean isPrimeOptimised(int n) {
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
}
