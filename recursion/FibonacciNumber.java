package recursion;

/**
 * Fibonacci Number
 * ==================
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum
 * of the two preceding ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 * 
 * Time Complexity: O(2^n) — due to repeated recursive calls without memoization
 * Space Complexity: O(n) — max depth of recursion stack
 */
class FibonacciNumber {
    int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
