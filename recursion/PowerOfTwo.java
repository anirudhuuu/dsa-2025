package recursion;

/**
 * Power of Two
 * ===============
 * Given an integer n, return true if it is a power
 * of two. Otherwise, return false.
 * 
 * An integer n is a power of two, if there exists
 * an integer x such that n == 2^x.
 * 
 * Time Complexity: O(log₂n) — each recursive call divides n by 2
 * Space Complexity: O(log₂n) — due to recursion stack depth
 */
class PowerOfTwo {
    boolean isPowerOfTwo(double n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2.0);
        }
    }
}
