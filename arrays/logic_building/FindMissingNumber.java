package arrays.logic_building;

/**
 * Given an integer array of size n containing distinct values in the range
 * from 0 to n (inclusive), return the only number missing from
 * the array within this range.
 */
public class FindMissingNumber {
    // Brute force approach
    int missingNumberBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            boolean isMissingValue = true;

            // For every value in the range of 0 to n (inclusive)
            // with searchKey find in nums[]
            for (int num : nums) {
                if (num == i) {
                    isMissingValue = false;
                    break;
                }
            }

            if (isMissingValue) {
                return i;
            }
        }

        return -1;
    }

    // Hashing approach
    int missingNumberBest(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];

        for (int num : nums) {
            frequency[num] = 1;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    // Mathematics approach
    int missingNumber(int[] nums) {
        int n = nums.length;

        int sumOfN = (n * (n + 1)) / 2;

        int sumOfNums = 0;
        for (int num : nums) {
            sumOfNums += num;
        }

        return sumOfN - sumOfNums;
    }
}
