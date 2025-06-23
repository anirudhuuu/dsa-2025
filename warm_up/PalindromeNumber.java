package warm_up;

// https://leetcode.com/problems/palindrome-number/description/
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int reversed = 0;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp = temp / 10;
        }

        return reversed == x;
    }

    public static void main(String[] args) {
        int number = -121;
        System.out.println(isPalindrome(number));
    }
}
