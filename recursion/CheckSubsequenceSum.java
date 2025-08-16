package recursion;

/**
 * Check if there exists a subsequence with sum K
 * ================================================
 * Given an array nums and an integer k. Return true if there exist
 * subsequences such that the sum of all elements in subsequences is equal to k
 * else false.
 */
public class CheckSubsequenceSum {
    public static boolean checkSum(int index, int N, int[] nums, int k) {
        // if the sum k is 0, a subsequence is found
        if (k == 0) {
            return true;
        }

        // if k is negative, no valid subsequence can be found
        if (k < 0) {
            return false;
        }

        // if all elements are processed, check if k is 0
        if (index == N) {
            return k == 0;
        }

        // include the current element in the subsequence
        boolean includeElement = checkSum(index + 1, N, nums, k - nums[index]);

        // exclude the current element from the subsequence
        boolean excludeElement = checkSum(index + 1, N, nums, k);

        return includeElement || excludeElement;
    }

    public static boolean checkSubsequenceSum(int[] nums, int k) {
        int N = nums.length;
        return checkSum(0, N, nums, k);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 9, 2 };
        int k = 10;

        System.out.println(checkSubsequenceSum(nums, k));
    }
}
