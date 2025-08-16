package recursion.basics;

/**
 * Factorial of a Given Number
 * ==============================
 * Given an integer n, return the factorial of n.
 * 
 * Factorial of a non-negative integer, is the multiplication of all integers
 * smaller than or equal to n (use 64-bits to return answer).
 */
public class FactorialOfN {
    public static long factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
}
