package arrays.fundamentals;

/**
 * Linear Search
 * ===============
 * Given an array of integers nums and an integer target,
 * find the smallest index (0 based indexing) where the target
 * appears in the array. If the target is not found in the array, return -1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinearSearch01 {
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -4, 4, 0, 10 };
        int key = 6;

        System.out.println(linearSearch(arr, key));
    }
}
