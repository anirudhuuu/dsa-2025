package arrays.fundamentals;

import java.util.Arrays;

public class SecondLargestElement {
    public static int secondLargestBrute(int[] nums) {
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

    public static int secondLargestBetter(int[] nums) {
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

    public static int secondLargestOptimal(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {3, 3, 6, 1};

        System.out.println(secondLargestBrute(nums));
        System.out.println(secondLargestBetter(nums));
        System.out.println(secondLargestOptimal(nums));
    }
}
