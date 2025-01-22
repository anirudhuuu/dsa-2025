package basics.maths;

/**
 * You are given an integer n. You need to check if the number is a
 * perfect number or not. Return true if it is a perfect number,
 * otherwise, return false.
 * <p>
 * A perfect number is a number whose proper divisors add up
 * to the number itself.
 */
public class PerfectNumber {
    public boolean isPerfect(int n) {
        int perfectCount = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                perfectCount += i;
            }
        }

        return perfectCount == n;
    }
}
