package basics.strings;

import java.util.Arrays;

/**
 * Valid Anagram
 * ===============
 * Given two strings s and t, return true if t is an
 * anagram of s, and false otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the
 * letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * 
 * Brute Force
 * ------------
 * Time: O(n log n) due to sorting both strings
 * Space: O(n) to store char[] arrays for s and t
 * 
 * Optimised Solution
 * ---------------------
 * Time: O(n) single pass through both strings + fixed loop of 26
 * Space: O(1) uses fixed-size array of 26 integers
 */
public class ValidAnagram {
    // Brute Force
    boolean anagramStringsBrute(String s, String t) {
        // Base condition check
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    // Optimised Solution
    boolean anagramStrings(String s, String t) {
        // Base condition check
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            frequency[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
