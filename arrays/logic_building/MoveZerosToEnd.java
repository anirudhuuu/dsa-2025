package arrays.logic_building;

/**
 * Given an integer array nums, move all the 0's to the end of the array.
 * The relative order of the other elements must remain the same.
 * <p>
 * This must be done in place, without making a copy of the array.
 */
public class MoveZerosToEnd {
    void moveZeroes(int[] nums) {
        int currentIndex = 0;
        // Capture all non-zero values and set from start
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                currentIndex += 1;
            }
        }

        // Set rest of the part with zeros
        for (int i = currentIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
