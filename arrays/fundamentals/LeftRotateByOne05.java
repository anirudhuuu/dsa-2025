package arrays.fundamentals;

/**
 * Left Rotate Array by One
 * ===========================
 * Given an integer array nums, rotate the array to the left by one.
 * 
 * Note: There is no need to return anything, just modify the given array.
 */
public class LeftRotateByOne05 {
    /**
     * Brute force approach
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void rotateArrayByOneBrute(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            result[i - 1] = nums[i];
        }

        result[nums.length - 1] = nums[0];
    }

    /**
     * Without any extra space
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        rotateArrayByOneBrute(nums1);

        for (int val : nums1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] nums2 = { 1, 2, 3, 4, 5 };
        rotateArrayByOne(nums2);

        for (int val : nums2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
