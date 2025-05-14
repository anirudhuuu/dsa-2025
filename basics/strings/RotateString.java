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
