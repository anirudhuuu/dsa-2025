package sorting;

/**
 * Bubble Sort
 * ============
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the bubble sort algorithm and return the sorted array.
 */
public class BubbleSort02 {
    /**
     * Push the maximum value to the last by adjacent swaps
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            // the largest value will be set at the end of list after an swap iteration
            for (int j = 0; j <= i - 1; j++) {
                /**
                 * The comparison nums[j] > nums[j + 1] checks if two adjacent elements are out
                 * of order (i.e., the left one is greater than the right). If so, the swap puts
                 * the larger value to the right, "bubbling" it toward the end of the array.
                 * This is the core idea of bubble sort: repeatedly swapping adjacent
                 * out-of-order elements to sort the array.
                 */
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };
        int[] result = bubbleSort(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
