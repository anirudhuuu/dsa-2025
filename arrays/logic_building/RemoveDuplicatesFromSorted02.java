package arrays.logic_building;

import java.util.Set;
import java.util.TreeSet;

/**
 * Remove Duplicates from Sorted Array
 * ====================================
 * Given an integer array nums sorted in non-decreasing order,
 * remove all duplicates in-place so that each unique element
 * appears only once.
 * 
 * "Return the number of unique elements in the array."
 * 
 * If the number of unique elements be k, then,
 * - Change the array nums such that the first k elements
 * of nums contain the unique values in the order that they were present
 * originally.
 * - The remaining elements, as well as the size of the
 * array does not matter in terms of correctness.
 * 
 * An array sorted in non-decreasing order is an array where
 * every element to the right of an element is either equal
 * to or greater in value than that element.
 */
public class RemoveDuplicatesFromSorted02 {
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int removeDuplicatesBrute(int[] nums) {
        // To store values in order of insertion
        Set<Integer> set = new TreeSet<>();

        // Iterate over entire data of nums
        for (int num : nums) {
            set.add(num);
        }

        /*
         * int j = 0;
         * for (int val : set) {
         * nums[j] = val;
         * j += 1;
         * }
         */
        return set.size();
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i += 1;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        System.out.println(removeDuplicatesBrute(nums));
        System.out.println(removeDuplicates(nums));
    }
}
