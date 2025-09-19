package sorting;

/**
 * Quick Sort
 * ============
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the quick sort algorithm and return the sorted array.
 */
public class QuickSort05 {
    /**
     * Pick a pivot & place it in its correct place in the sorted array
     * Others, smaller on the left
     * larger on the right
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public static int sort(int[] nums, int low, int high) {
        int pivotElement = nums[low];

        int i = low;
        int j = high;

        while (i < j) {
            // Check bounds before accessing nums[i] and nums[j]
            while (i <= high && nums[i] <= pivotElement) {
                i += 1;
            }

            while (j >= low && nums[j] > pivotElement) {
                j -= 1;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;

        return j;
    }

    public static void quickSortAlgo(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = sort(nums, low, high);

            quickSortAlgo(nums, low, pivotIndex - 1);
            quickSortAlgo(nums, pivotIndex + 1, high);
        }
    }

    public static int[] quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        quickSortAlgo(nums, low, high);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 2, 5, 7, 9, 1, 3 };
        int[] result = quickSort(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
