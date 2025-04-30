package arrays.fundamentals;

public class RightRotateByOne {
    // Brute force approach
    void rotateArrayByOneBrute(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            result[i + 1] = nums[i];
        }

        result[0] = nums[nums.length - 1];
    }

    // Without any extra space
    void rotateArrayByOne(int[] nums) {
        int temp = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = temp;
    }
}
