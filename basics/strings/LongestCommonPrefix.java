package basics.strings;

import java.util.Arrays;

/**
 * Longest Common Prefix
 * ========================
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Time Complexity: O(n·log n + m) — n·log n for sorting n strings,
 * and m for comparing the first and last strings character by
 * character (where m is length of the shortest string).
 * 
 * Space Complexity: O(1) — ignoring output string (since it's derived),
 * only a few pointers are used.
 */
class LongestCommonPrefix {
    String longestCommonPrefix(String[] str) {
        String result = "";

        Arrays.sort(str);

        String word1 = str[0];
        String word2 = str[str.length - 1];

        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                break;
            }

            result += word1.charAt(i);

            i += 1;
            j += 1;
        }

        return result;
    }
}
