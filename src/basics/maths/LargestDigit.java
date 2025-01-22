package basics.maths;

/**
 * You are given an integer n. Return the largest digit
 * present in the number.
 */
public class LargestDigit {
    public int largestDigit(int n) {
        int largest = 0;

        while (n > 0) {
            int digit = n % 10;
            largest = Math.max(digit, largest);
            n = n / 10;
        }

        return largest;
    }
}
