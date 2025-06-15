package recursion;

/**
 * Power of Four
 * ===============
 * Given an integer n, return true if it is a power of four.
 * Otherwise, return false.
 * 
 * An integer n is a power of four, if there exists
 * an integer x such that n == 4x.
 * 
 * Time Complexity: O(log₄n) ≈ O(log₂n) — divides n by 4 each call
 * Space Complexity: O(log₄n) — recursion stack depth
 */
class PowerOfFourt {
    boolean isPowerOfFour(double n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        } else {
            return isPowerOfFour(n / 4.0);
        }
    }
}
