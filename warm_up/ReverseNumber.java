package warm_up;

// https://leetcode.com/problems/reverse-integer/description/
public class ReverseNumber {
    public static int reverse(int x) {
        int temp = Math.abs(x);
        int reverse = 0;

        while (temp != 0) {
            int digit = temp % 10;

            // If reversing x causes the value to go outside
            // the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
            if (reverse < Integer.MIN_VALUE / 10 ||
                    reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }

            reverse = (reverse * 10) + digit;
            temp = temp / 10;
        }

        if (x < 0) {
            reverse = reverse * -1;
        }

        return reverse;
    }

    public static void main(String[] args) {
        int number = 2147483647;
        System.out.println(reverse(number));
    }
}
