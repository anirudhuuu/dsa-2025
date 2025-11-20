package heaps;

import java.util.Arrays;

/*
 * Heapify Algorithm
 * =====================
 * Given an array nums representing a max-heap and two integers ind and val, set
 * the value at index ind (0-based) to val and perform the heapify algorithm
 * such that the resulting array follows the max-heap property.
 *
 * Modify the original array in-place, no need to return anything.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Heapify03 {
    public void heapifyUp(int[] nums, int index) {
        // find parent's index
        int parentIndex = (index - 1) / 2;

        // if current value is greater than parent, percolate up in max-heap
        if (index > 0 && nums[index] > nums[parentIndex]) {
            // swap current value and parent
            int temp = nums[index];
            nums[index] = nums[parentIndex];
            nums[parentIndex] = temp;

            // recursively heapify the upper nodes
            heapifyUp(nums, parentIndex);
        }
    }

    public void heapifyDown(int[] nums, int index) {
        int n = nums.length;

        int largestIndex = index;

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has larger value then take that
        if (leftChildIndex < n && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        // if the right child has larger value then take that
        if (rightChildIndex < n && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        // once the largest element is found
        if (largestIndex != index) {
            // swap the latest large value to the node where it shall be
            int temp = nums[largestIndex];
            nums[largestIndex] = nums[index];
            nums[index] = temp;

            // recursively heapify the bottom nodes
            heapifyDown(nums, largestIndex);
        }
    }

    public void heapify(int[] nums, int index, int value) {
        if (nums[index] < value) {
            // value increased, try bubbling up
            nums[index] = value;
            heapifyUp(nums, index);
        } else {
            // value decreased or same, try bubbling down
            nums[index] = value;
            heapifyDown(nums, index);
        }
    }

    static void main() {
        int[] nums = {25, 20, 18, 15, 10, 8, 7}; // valid max-heap

        System.out.println("Original array: " + Arrays.toString(nums));

        // Change value at index 3 (was 15) to 30 and restore the heap
        new Heapify03().heapify(nums, 3, 30);
        System.out.println("After heapify at index 3 with value 30: " + Arrays.toString(nums));

        // Change value at index 0 (was 25) to 5 and restore the heap
        new Heapify03().heapify(nums, 0, 5);
        System.out.println("After heapify at index 0 with value 5: " + Arrays.toString(nums));
    }
}
