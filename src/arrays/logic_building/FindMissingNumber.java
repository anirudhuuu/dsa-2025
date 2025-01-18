package arrays.logic_building;

/**
 * Given an integer array of size n containing distinct values in the range
 * from 0 to n (inclusive), return the only number missing from
 * the array within this range.
 */
public class FindMissingNumber {
    // Brute force approach
    public static int missingNumberBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            boolean isMissingValue = true;

            // For every value in the range of 0 to n (inclusive) with searchKey find in nums[]
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
    public static int missingNumberBest(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];

        for (int num : nums) {
            frequency[num] = 1;
        }

        int missingNumber = -1;

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 0) {
                missingNumber = i;
                break;
            }
        }

        return missingNumber;
    }

    // Mathematics approach
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int sumOfN = (n * (n + 1)) / 2;

        int sumOfNums = 0;
        for (int num : nums) {
            sumOfNums += num;
        }

        return sumOfN - sumOfNums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 4, 2, 5};
        int[] nums1 = {0, 2, 3, 1, 4};
        int[] nums2 = {0, 1, 2, 4, 5, 6};

        System.out.println(missingNumberBrute(nums));
        System.out.println(missingNumberBest(nums1));
        System.out.println(missingNumber(nums2));
    }
}
