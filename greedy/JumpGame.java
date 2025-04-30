package greedy;

/**
 * Given an array of integers nums, each element in the array
 * represents the maximum jump length at that position.
 * <p>
 * Initially starting at the first index of the array,
 * determine if it is possible to reach the last index.
 * <p>
 * Return true if the last index can be reached, otherwise return false.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for (int i = 0; i <= n - 1; i++) {
            if (i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};

        System.out.println("Can I jump till end? :: " + canJump(arr));
    }
}
