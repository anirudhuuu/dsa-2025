package basics.maths;

/**
 * You are given an integer n. You need to return the number of odd
 * digits present in the number.
 * <p>
 * The number will have no leading zeroes, except when the number is 0 itself.
 */
public class CountOddDigits {
    public int countOddDigit(int n) {
        if (n == 0) {
            return 0;
        }

        int noOfDigits = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit % 2 != 0) {
                noOfDigits += 1;
            }

            n = n / 10;
        }

        return noOfDigits;
    }
}
