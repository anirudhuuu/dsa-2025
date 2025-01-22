package basics.maths;

/**
 * You are given an integer n. You need to check if the number is prime
 * or not. Return true if it is a prime number, otherwise return false.
 * <p>
 * A prime number is a number which has no divisors except 1 and itself.
 */
public class CheckPrimeNumber {
    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
