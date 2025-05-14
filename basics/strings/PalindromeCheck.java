package basics.strings;

/**
 * Palindrome Check
 * ==================
 * You are given a string s. Return true if the string
 * is palindrome, otherwise false. A string is called
 * palindrome if it reads the same forward and backward.
 * 
 * Time Complexity: O(n) — where n is the length of the string;
 * each character is checked once from both ends.
 * 
 * Space Complexity: O(1) — no extra space used beyond a few integer variables.
 */
class PalindromeCheck {
    boolean palindromeCheck(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }

            startIndex += 1;
            endIndex -= 1;
        }

        return true;
    }
}
