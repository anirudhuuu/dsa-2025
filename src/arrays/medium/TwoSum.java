package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target.
 * Return the indices(0 - indexed) of two elements in nums
 * such that they add up to target.
 * <p>
 * Each input will have exactly one solution, and the same
 * element cannot be used twice.
 * <p>
 * Return the answer in non-decreasing order.
 */
public class TwoSum {
    // Brute force algorithm
    int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;
        int[] answer = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }

        return new int[]{-1, -1};
    }

    // Better algorithm
    int[] twoSumBetter(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int lookUp = target - nums[i];

            if (frequency.get(lookUp) != null) {
                int indexValue = frequency.get(lookUp);
                answer[0] = i;
                answer[1] = indexValue;
                break;
            } else {
                frequency.put(nums[i], i);
            }
        }

        Arrays.sort(answer);

        return answer;
    }

    // Optimal algorithm
    int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        // Keep track of num[i] value + it's original index in num
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            // Store value and index
            arr[i] = new int[]{nums[i], i};
        }

        // Sort this "arr" by nums[i]
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return new int[]{-1, -1};
    }
}
