package arrays.fundamentals;

import java.util.Arrays;

/**
 * Largest Element
 * ==================
 * Given an array of integers nums, return the value of the largest element in
 * the array
 */
public class LargestElement02 {
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public static int largestElementBrute(int[] nums) {
        // When the input is empty
        if (nums.length == 0)
            return -1;

        // Sort the given array in ascending ordering
        Arrays.sort(nums);

        return nums[nums.length - 1];
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int largestElementBest(int[] nums) {
        if (nums.length == 0)
            return -1;

        int largestElement = nums[0];

        for (int num : nums) {
            largestElement = Math.max(largestElement, num);
        }

        return largestElement;
    }

    public static void main(String[] args) {
        int[] arr = { -4, -3, 0, 1, -8 };

        System.out.println(largestElementBrute(arr));
        System.out.println(largestElementBest(arr));
    }
}
