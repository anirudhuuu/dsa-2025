package recursion.basics;

/**
 * Sum of Array Elements
 * ========================
 * Given an array nums, find the sum of elements of array using recursion.
 */
public class SumOfArr {
    public static int sum(int[] nums, int currIndex) {
        if (currIndex >= nums.length) {
            return 0;
        }

        return nums[currIndex] + sum(nums, currIndex + 1);
    }

    public static int arraySum(int[] nums) {
        return sum(nums, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(arraySum(nums));
    }
}
