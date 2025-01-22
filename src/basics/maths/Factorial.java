package basics.maths;

/**
 * You are given an integer n. Return the value of n! or n factorial.
 * <p>
 * Factorial of a number is the product of all positive integers less
 * than or equal to that number.
 */
public class Factorial {
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
}
