package basics.strings;

/**
 * Isomorphic String
 * ==================
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s
 * can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another
 * character while preserving the order of characters. No two characters
 * may map to the same character, but a character may map to itself.
 */
class IsomorphicString {
    boolean isomorphicString(String s, String t) {
        // base condition check
        if (s.length() != t.length()) {
            return false;
        }

        // arrays to keep track of positions of characters in s & t
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            // when the last seen position of the current characters,
            // don't match then return
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }

            // update the last seen positions of the characters
            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
