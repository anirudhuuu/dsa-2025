package arrays.leetcode;

/**
 * Remove Duplicates from Sorted Array
 * ====================================
 * Given an integer array nums sorted in non-decreasing order, remove
 * the duplicates in-place such that each unique element appears only
 * once. The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k,
 * to get accepted, you need to do the following things:
 * 
 * - Change the array nums such that the first k elements of nums
 * contain the unique elements in the order they were present in
 * nums initially. The remaining elements of nums are not important
 * as well as the size of nums.
 * 
 * - Return k.
 * 
 * 
 * Time Complexity: O(n) — one pass for filtering, one for copying.
 * Space Complexity: O(n) — uses temp array of size n.
 */
class RemoveDuplicates {
    int removeDuplicates(int[] nums) {
        int k = 1;
        int[] temp = new int[nums.length];

        temp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            temp[k] = nums[i];
            k += 1;
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return k;
    }
}
