package basics.maths;

/**
 * You are given an integer n. You need to check whether the number
 * is a palindrome number or not. Return true if it's a palindrome
 * number, otherwise return false.
 * <p>
 * A palindrome number is a number which reads the same both left to
 * right and right to left.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int n) {
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            reverse = (reverse * 10) + digit;
            temp = temp / 10;
        }

        return reverse == n;
    }
}
