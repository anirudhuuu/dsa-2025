package heaps;

/*
 * Build heap from a given Array
 * ==============================
 * Given an array of integers nums, convert it in-place into a min-heap.
 *
 * A binary min-heap is a complete binary tree where the key at the root is the
 * minimum among all keys present in a binary min-heap and the same property is
 * recursively true for all nodes in a Binary Tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BuildMinHeap05 {
    void heapifyDown(int[] nums, int index) {
        int n = nums.length;

        // index of smallest element
        int smallestIndex = index;

        // indexes of left/right children
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has the smallest value, update the smallest index
        if (leftChildIndex < n && nums[leftChildIndex] < nums[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        // if the right child has the smallest value, update the smallest index
        if (rightChildIndex < n && nums[rightChildIndex] < nums[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        // if we find a small value in the children, then swap
        if (smallestIndex != index) {
            // swap the smallest element with the current index
            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[index];
            nums[index] = temp;

            heapifyDown(nums, smallestIndex);
        }
    }

    void buildMinHeap(int[] nums) {
        int noOfNodes = nums.length;

        // on all the internal nodes
        // as leaf nodes are in proper place already
        for (int i = noOfNodes / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
    }

    static void main() {
        int[] nums = {6, 5, 2, 7, 1, 7};

        new BuildMinHeap05().buildMinHeap(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
