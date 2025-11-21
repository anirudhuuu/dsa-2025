package heaps;

/*
 * Build heap from a given Array
 * ==============================
 * Given an array of integers nums, convert it in-place into a max-heap.
 *
 * A binary max-heap is a complete binary tree where the key at the root is the
 * maximum among all keys present in a binary max-heap and the same property is
 * recursively true for all nodes in a Binary Tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BuildMaxHeap06 {
    void heapifyDown(int[] nums, int index) {
        int n = nums.length;

        // index of largest element
        int largestIndex = index;

        // indexes of left/right children
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has the largest value, update the largest index
        if (leftChildIndex < n && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        // if the right child has the largest value, update the largest index
        if (rightChildIndex < n && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        // if we find a larger value in the children, then swap
        if (largestIndex != index) {
            // swap the largest element with the current index
            int temp = nums[largestIndex];
            nums[largestIndex] = nums[index];
            nums[index] = temp;

            heapifyDown(nums, largestIndex);
        }
    }

    void buildMaxHeap(int[] nums) {
        int noOfNodes = nums.length;

        for (int i = noOfNodes / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
    }

    static void main() {
        int[] nums = {6, 5, 2, 7, 1, 7};

        new BuildMaxHeap06().buildMaxHeap(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
