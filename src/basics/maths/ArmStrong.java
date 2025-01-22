package basics.maths;

/**
 * You are given an integer n. You need to check whether it is an
 * armstrong number or not. Return true if it is an armstrong number,
 * otherwise return false.
 * <p>
 * An armstrong number is a number which is equal to the sum of the
 * digits of the number, raised to the power of the number of digits.
 */
public class ArmStrong {
    public boolean isArmstrong(int n) {
        int noOfDigits = 0;
        int temp = n;

        while (temp > 0) {
            noOfDigits += 1;
            temp = temp / 10;
        }

        int sum = 0;
        temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, noOfDigits);
            temp = temp / 10;
        }

        return sum == n;
    }
}
