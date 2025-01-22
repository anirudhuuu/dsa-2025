package basics.maths;

/**
 * You are given an integer n. You need to return the number
 * of digits in the number.
 * <p>
 * The number will have no leading zeroes, except when the
 * number is 0 itself.
 */
public class CountAllDigits {
    public int countDigit(int n) {
        if (n == 0) {
            return 1;
        }

        int noOfDigits = 0;

        while (n > 0) {
            noOfDigits += 1;
            n = n / 10;
        }

        return noOfDigits;
    }

    public int countDigitOptimal(int n) {
        if (n == 0) {
            return 1;
        }

        return (int) (Math.log10(n) + 1);
    }
}
