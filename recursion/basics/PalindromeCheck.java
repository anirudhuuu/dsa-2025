package recursion.basics;

/**
 * Check if String is Palindrome or Not
 * =======================================
 * Given a string s, return true if the string is palindrome, otherwise false.
 * 
 * A string is called palindrome if it reads the same forward and backward.
 */
public class PalindromeCheck {
    public static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    public static boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(palindromeCheck("hannah"));
    }
}
