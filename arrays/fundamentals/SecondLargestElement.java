package arrays.fundamentals;

import java.util.Arrays;

/**
 * Given an array of integers nums, return the second-largest
 * element in the array.
 * <p>
 * If the second-largest element does not exist, return -1.
 */
public class SecondLargestElement {
    int secondLargestBrute(int[] nums) {
        // When the input is empty or has only single value
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        // Sort the given array in ascending ordering
        Arrays.sort(nums);

        // Get the largest element
        int largestElement = nums[nums.length - 1];

        // Search for the second-largest element
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < largestElement) {
                return nums[i];
            }
        }

        return -1;
    }

    int secondLargestBetter(int[] nums) {
        // When the input is empty or has only single value
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        // Avoid sorting in this approach
        // rather find the largest and then look for second-largest
        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int num : nums) {
            largestElement = Math.max(largestElement, num);
        }

        for (int num : nums) {
            if (num > secondLargestElement && num != largestElement) {
                secondLargestElement = num;
            }
        }

        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }

    int secondLargestOptimal(int[] nums) {
        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largestElement) {
                secondLargestElement = largestElement;
                largestElement = num;
            } else if (num > secondLargestElement && num != largestElement) {
                secondLargestElement = num;
            }
        }

        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }
}
