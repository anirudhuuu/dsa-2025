package basics.strings;

/**
 * Rotate String
 * ===============
 * Given two strings s and goal, return true if and only if
 * s can become goal after some number of shifts on s.
 * 
 * A shift on s consists of moving the leftmost character
 * of s to the rightmost position.
 * 
 * For example,
 * if s = "abcde",
 * then it will be "bcdea" after one shift.
 * 
 * Brute Force
 * ------------
 * Time Complexity: O(n²) — n rotations, each creating a new string of
 * up to n length.
 * 
 * Space Complexity: O(n) — space for each rotated string.
 * 
 * Optimized Version
 * ------------------
 * Time Complexity: O(n) — checking substring presence in s + s using contains.
 * 
 * Space Complexity: O(n) — for the concatenated string s + s.
 */
class RotateString {
    // Brute force method
    boolean rotateStringBrute(String s, String goal) {
        // Base condition
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i + 1) + s.substring(0, i + 1);
            if (goal.equals(rotated)) {
                return true;
            }
        }

        return false;
    }

    // Optimised
    boolean rotateString(String s, String goal) {
        // Base condition
        if (s.length() != goal.length()) {
            return false;
        }

        String builderStr = s + s;

        if (builderStr.contains(goal)) {
            return true;
        }

        return false;
    }
}
