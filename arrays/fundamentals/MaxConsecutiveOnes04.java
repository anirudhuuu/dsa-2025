package arrays.fundamentals;

/**
 * Given a binary array nums, return the maximum
 * number of consecutive 1s in the array.
 * <p>
 * A binary array is an array that contains only 0s and 1s.
 */
public class MaxConsecutiveOnes04 {
    /**
     * Time Complexity: O(n), where n is the length of the input array nums.
     * Space Complexity: O(1)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count += 1;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
