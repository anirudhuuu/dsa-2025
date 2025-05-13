package basics.strings;

/**
 * Palindrome Check
 * ==================
 * You are given a string s. Return true if the string
 * is palindrome, otherwise false. A string is called
 * palindrome if it reads the same forward and backward.
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
