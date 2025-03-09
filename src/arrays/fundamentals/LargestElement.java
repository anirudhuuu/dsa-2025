package arrays.fundamentals;

import java.util.Arrays;

/**
 * Given an array of integers nums, return the
 * value of the largest element in the array
 */
public class LargestElement {
    int largestElementBrute(int[] nums) {
        // When the input is empty
        if (nums.length == 0) return -1;

        // Sort the given array in ascending ordering
        Arrays.sort(nums);

        return nums[nums.length - 1];
    }

    int largestElementBest(int[] nums) {
        if (nums.length == 0) return -1;

        int largestElement = nums[0];

        for (int num : nums) {
            largestElement = Math.max(largestElement, num);
        }

        return largestElement;
    }
}
