package arrays.fundamentals;

public class LeftRotateByOne {
    // Brute force approach
    public static void rotateArrayByOneBrute(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            result[i - 1] = nums[i];
        }

        result[nums.length - 1] = nums[0];

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Without any extra space
    public static void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotateArrayByOneBrute(nums);
        System.out.println();
        rotateArrayByOne(nums);
    }
}
