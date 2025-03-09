package arrays.fundamentals;

/**
 * Given an integer array nums, rotate the array to the left by one.
 * <p>
 * Note: There is no need to return anything, just modify the given array.
 */
public class LeftRotateByOne {
    // Brute force approach
    void rotateArrayByOneBrute(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            result[i - 1] = nums[i];
        }

        result[nums.length - 1] = nums[0];
    }

    // Without any extra space
    void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }
}
