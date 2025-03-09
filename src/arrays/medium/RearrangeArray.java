package arrays.medium;

/**
 * Given an integer array nums of even length consisting
 * of an equal number of positive and negative integers.
 * Return the answer array in such a way that the given conditions are met:
 * <p>
 * - Every consecutive pair of integers have opposite signs.
 * - For all integers with the same sign, the order in which
 * they were present in nums is preserved.
 * - The rearranged array begins with a positive integer.
 */
public class RearrangeArray {
    int[] rearrangeArray(int[] nums) {
        int positiveIndex = 0;
        int negativeIndex = 1;

        int[] result = new int[nums.length];

        for (int num : nums) {
            if (num > 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            } else if (num < 0) {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        return result;
    }
}
