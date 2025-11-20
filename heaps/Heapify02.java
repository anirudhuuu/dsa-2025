package heaps;

import java.util.Arrays;

/*
 * Heapify Algorithm
 * =====================
 * Given an array nums representing a min-heap and two integers ind and val, set
 * the value at index ind (0-based) to val and perform the heapify algorithm
 * such that the resulting array follows the min-heap property.
 *
 * Modify the original array in-place, no need to return anything.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Heapify02 {
    void heapifyUp(int[] nums, int index) {
        // find parent's index
        int parentIndex = (index - 1) / 2;

        // if current value that is added; holds a smaller value than its parent
        // it means it shall go up to where parent is present
        if (index > 0 && nums[index] < nums[parentIndex]) {
            // swap current value and parent
            int temp = nums[index];
            nums[index] = nums[parentIndex];
            nums[parentIndex] = temp;

            // recursively heapify the upper nodes
            heapifyUp(nums, parentIndex);
        }
    }

    void heapifyDown(int[] nums, int index) {
        int n = nums.length;

        // this is where correct value has to come from bottom
        int smallestIndex = index;

        // left and right children of the small node
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has smaller value then take that
        if (leftChildIndex < n && nums[leftChildIndex] < nums[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        // if the right child has smaller value then take that
        if (rightChildIndex < n && nums[rightChildIndex] < nums[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        // once the smallest element is found
        if (smallestIndex != index) {
            // swap the latest small value to the node where it shall be
            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[index];
            nums[index] = temp;

            // recursively heapify the bottom nodes
            heapifyDown(nums, smallestIndex);
        }
    }

    void heapify(int[] nums, int index, int value) {
        if (nums[index] > value) {
            // new value getting added is smaller than what was present before
            // so we move small value to top in min-heap
            nums[index] = value;
            heapifyUp(nums, index);
        } else {
            // new value getting added is greater than what was present before
            // so we move large value to bottom in min-heap
            nums[index] = value;
            heapifyDown(nums, index);
        }
    }

    static void main() {
        int[] nums = {7, 10, 8, 15, 20, 18, 25}; // valid min-heap

        System.out.println("Original array: " + Arrays.toString(nums));

        // Change value at index 3 (was 15) to 5 and restore the heap
        new Heapify02().heapify(nums, 3, 5);
        System.out.println("After heapify at index 3 with value 5: " + Arrays.toString(nums));

        // Change value at index 0 (was 7) to 30 and restore the heap
        new Heapify02().heapify(nums, 0, 30);
        System.out.println("After heapify at index 0 with value 30: " + Arrays.toString(nums));
    }
}
