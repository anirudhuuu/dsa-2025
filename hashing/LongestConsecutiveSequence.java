package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums of n integers, return the length of the longest sequence of
 * consecutive integers. The integers in this sequence can appear in any order.
 */
public class LongestConsecutiveSequence {
    // Brute force approach O(N ^ 2)
    public static boolean linearSearch(int[] arr, int search) {
        for (int num : arr) {
            if (num == search) {
                return true;
            }
        }

        return false;
    }

    public static int longestConsecutiveBrute(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int longestSequence = 1;

        // Pick each value of the input array and search for it's consecutive value
        for (int num : arr) {
            int pickedValue = num;
            int consecutiveCount = 1;

            // Look for the next value's presence based on the pickedValue
            while (linearSearch(arr, pickedValue + 1)) {
                // If present, update current pickedValue and consecutiveCount
                pickedValue = pickedValue + 1;
                consecutiveCount = consecutiveCount + 1;
            }

            // Pick the longest consecutive sequence count
            longestSequence = Math.max(longestSequence, consecutiveCount);
        }

        return longestSequence;
    }

    // Better approach O(N log N)
    public static int longestConsecutiveBetter(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);  // Sort the given array in time complexity of N log(N)

        int currentCount = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int longestSequence = 1;

        // Iterate over each sorted value
        for (int num : arr) {
            if (num - 1 == lastSmaller) {
                currentCount += 1;
                lastSmaller = num;
            } else if (num - 1 != lastSmaller) {
                // When values are different, then sequence doesn't exist so reset
                currentCount = 1;
                lastSmaller = num;
            }

            // Pick the longest consecutive sequence count
            longestSequence = Math.max(longestSequence, currentCount);
        }

        return longestSequence;
    }

    // Optimal approach O(N)
    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int longestSequence = 1;
        // Put all the array elements into the set
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Traverse the set to find the longest sequence
        for (int val : set) {
            // Check if 'val' is a starting number of a sequence
            if (!set.contains(val - 1)) {
                int currentCount = 1; // Initialize the count of the current sequence
                int x = val; // Starting element of the sequence

                // Find consecutive numbers in the set for 'x'
                while (set.contains(x + 1)) {
                    x = x + 1;
                    currentCount = currentCount + 1;
                }

                longestSequence = Math.max(longestSequence, currentCount);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};

        System.out.println("Longest consecutive sequence :: " + longestConsecutiveBrute(arr));
        System.out.println("Longest consecutive sequence :: " + longestConsecutiveBetter(arr));
    }
}
