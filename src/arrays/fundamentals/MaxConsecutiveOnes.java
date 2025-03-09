package arrays.fundamentals;

/**
 * Given a binary array nums, return the maximum
 * number of consecutive 1s in the array.
 * <p>
 * A binary array is an array that contains only 0s and 1s.
 */
public class MaxConsecutiveOnes {
    int findMaxConsecutiveOnes(int[] nums) {
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
}
