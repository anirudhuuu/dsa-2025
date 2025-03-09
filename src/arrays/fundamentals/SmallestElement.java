package arrays.fundamentals;

import java.util.Arrays;

public class SmallestElement {
    int smallestElementBrute(int[] nums) {
        // When the input is empty
        if (nums.length == 0) return -1;

        // Sort the given array in ascending ordering
        Arrays.sort(nums);

        return nums[0];
    }

    int smallestElementBest(int[] nums) {
        if (nums.length == 0) return -1;

        int smallestElement = nums[0];

        for (int num : nums) {
            smallestElement = Math.min(smallestElement, num);
        }

        return smallestElement;
    }
}
