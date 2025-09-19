package sorting;

/**
 * Insertion Sorting
 * ==================
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the insertion sort algorithm and return the sorted array.
 */
public class InsertionSort03 {
    /**
     * Takes an elements and places it in its correct position
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int[] insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n - 1; i++) {
            int j = i;

            while (j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;

                j -= 1;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 14, 9, 15, 12, 6, 8, 13 };
        int[] result = insertionSort(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
