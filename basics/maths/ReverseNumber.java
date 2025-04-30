package basics.maths;

/**
 * You are given an integer n. Return the integer formed
 * by placing the digits of n in reverse order.
 */
public class ReverseNumber {
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    int reverseNumber(int n) {
        int reverse = 0;

        while (n > 0) {
            int digit = n % 10;
            reverse = (reverse * 10) + digit;
            n = n / 10;
        }

        return reverse;
    }
}
