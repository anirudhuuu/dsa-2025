package arrays.fundamentals;

/**
 * Left Rotate Array by K
 * ===========================
 * Given an integer array nums and a non-negative integer k,
 * rotate the array to the left by k steps.
 */
public class LeftRotateByK06 {
    /**
     * Brute force approach
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public static void rotateArrayBrute(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[k];
        // Get the copy of the first k elements
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        // Copying the rest values to left position
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        /*
         * Keep the temp back in the array
         * =================================
         * int j = 0;
         *
         * for (int i = n - k; i < n; i++) {
         * nums[i] = temp[j];
         * j += 1;
         * }
         */
        for (int i = n - k; i < n; i++) {
            nums[i] = temp[i - (n - k)];
        }
    }

    /**
     * Reverse array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start += 1;
            end -= 1;
        }
    }

    /**
     * Optimal approach
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        reverseArray(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int k = 2;
        rotateArrayBrute(nums1, k);

        for (int val : nums1) {
            System.out.print(val + " ");
        }
        System.out.println();

        rotateArray(nums2, k);
        for (int val : nums2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
