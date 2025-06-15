package arrays.leetcode;

/**
 * Plus One
 * =========
 * You are given a large integer represented as an integer array
 * digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant
 * in left-to-right order. The large integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Time Complexity: O(n) — worst case touches all digits.
 * Space Complexity: O(n) — extra space only if carry adds a digit.
 */
class PlusOne {
    int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        return nums;
    }
}
