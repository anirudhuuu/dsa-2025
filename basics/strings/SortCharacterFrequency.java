package basics.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sort Characters by Frequency
 * ==============================
 * You are given a string s. Return the array of unique characters,
 * sorted by highest to lowest occurring characters.
 * 
 * If two or more characters have same frequency then arrange
 * them in alphabetic order.
 * 
 * Time Complexity
 * ------------------
 * Counting frequencies: O(n) where n is the length of string s
 * Sorting 26 characters: O(26 log 26) → constant time → O(1)
 * Final traversal to collect results: O(26) → O(1)
 * 
 * Total Time Complexity: O(n)
 * 
 * Space Complexity
 * ------------------
 * Pair[26] array → O(1)
 * Output list stores unique chars → max 26 → O(1)
 * 
 * Total Space Complexity: O(1)
 */
class SortCharacterFrequency {
    // helper class that keep track of no. of occurence wrt. character
    class Pair {
        int frequency;
        char character;

        Pair(int frequency, char character) {
            this.frequency = frequency;
            this.character = character;
        }
    }

    List<Character> frequencySort(String s) {
        // considering all lowercase alphabets
        Pair[] frequencyPair = new Pair[26];

        // set with all empty data of alphabets with 0 occurences
        for (int i = 0; i < 26; i++) {
            frequencyPair[i] = new Pair(0, (char) (i + 'a'));
        }

        // count frequency of each character in the input
        for (char ch : s.toCharArray()) {
            frequencyPair[ch - 'a'].frequency += 1;
        }

        // sort based on frequency (descending)
        // and alphabetically (ascending)
        Arrays.sort(frequencyPair, (p1, p2) -> {
            if (p1.frequency != p2.frequency) {
                return p2.frequency - p1.frequency;
            }

            return p1.character - p2.character;
        });

        List<Character> result = new ArrayList<>();

        // collect frequency result
        for (Pair p : frequencyPair) {
            if (p.frequency > 0) {
                result.add(p.character);
            }
        }

        return result;
    }
}
