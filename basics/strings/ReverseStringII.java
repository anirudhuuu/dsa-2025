package basics.strings;

import java.util.Vector;

/**
 * Reverse a String II
 * ========================
 * Given a string, the task is to reverse it. The string is
 * represented by an array of characters s. Perform the
 * reversal in place with O(1) extra memory.
 * 
 * Note: no need to return anything, modify the given list.
 * 
 * Time Complexity: O(n) — where "n" is the size of the vector;
 * each character is visited once.
 *
 * Space Complexity: O(1) — in-place swap using constant extra memory
 * ("temp" variable only).
 */
class ReverseStringII {
    void reverseString(Vector<Character> s) {
        int startIndex = 0;
        int endIndex = s.size() - 1;

        while (startIndex < endIndex) {
            char temp = s.get(startIndex);
            s.set(startIndex, s.get(endIndex));
            s.set(endIndex, temp);

            startIndex += 1;
            endIndex -= 1;
        }
    }
}
