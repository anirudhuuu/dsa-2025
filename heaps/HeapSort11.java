package heaps;

/**
 * Heap Sort
 * ============
 * Given an array of integers nums, sort the array in non-decreasing order using
 * the heap sort algorithm. Sort the given array itself, there is no need to
 * return anything.
 * <p>
 * A sorted array in non-decreasing order is one in which each element is either
 * greater than or equal to all the elements to its left in the array.
 * <p>
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class HeapSort11 {
    /**
     * Procedure:
     * 1. take an array input of nums
     * 2. build a max heap from given array
     * 3a. use the "extractMax()" functionality
     * 3b. swap the root node arr[0] with arr[last]
     * 3c. decrement the last value
     * 4. heapify down on arr[0]
     */
    public static void heapifyDown(int[] nums, int index, int lastIndex) {
        int largestIndex = index;

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex <= lastIndex && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex <= lastIndex && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            int temp = nums[largestIndex];
            nums[largestIndex] = nums[index];
            nums[index] = temp;

            heapifyDown(nums, largestIndex, lastIndex);
        }
    }

    public static void buildMaxHeap(int[] nums) {
        int n = nums.length; // no of nodes in heap

        // iterate on internal nodes
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i, n - 1);
        }
    }

    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);

        int last = nums.length - 1; // last index

        while (last > 0) {
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last -= 1;

            if (last > 0) {
                heapifyDown(nums, 0, last);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};
        heapSort(nums);

        for (int val : nums) {
            System.out.print(val + " ");
        }
        System.err.println();
    }
}
