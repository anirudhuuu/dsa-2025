package arrays.logic_building;

public class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                currentIndex += 1;
            }
        }

        for (int i = currentIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

        moveZeroes(nums);
    }
}
