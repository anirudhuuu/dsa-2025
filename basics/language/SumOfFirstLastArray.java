package basics.language;

/**
 * Given an integer array nums, return the sum of
 * the 1st and last element of the array.
 */
public class SumOfFirstLastArray {
    public int sumOfFirstAndLast(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];

        return first + last;
    }
}
