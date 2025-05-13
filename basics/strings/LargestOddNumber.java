package basics.strings;

/**
 * Largest Odd Number in a String
 * =================================
 * Given a string s, representing a large integer, the task is to
 * return the largest-valued odd integer (as a string) that is a
 * substring of the given string s.
 * 
 * The number returned should not have leading zero's. But the given
 * input string may have leading zero.
 * 
 * leading zeros are zeros that appear at the beginning of a
 * number before any non-zero digit.
 */
class LargestOddNumber {
    /*
     * As we have to find out the largest odd-number look for
     * the first digit, that is odd from right-side
     * once you find that index, from look for
     * the first digit, that is non-zero from left-side
     * make a sub-string out of this bounds and return
     */
    String largeOddNum(String s) {
        int j = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            // is it an odd-digit?
            if ((s.charAt(i) - '0') % 2 == 1) {
                j = i;
                break;
            }
        }

        // when odd-digit does not exist
        if (j == -1) {
            return "";
        }

        // look for first non-zero digit from start
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '0')
                break;

            i = i + 1;
        }

        return s.substring(i, j + 1);
    }
}
