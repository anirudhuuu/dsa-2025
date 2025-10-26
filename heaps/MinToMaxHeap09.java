package heaps;

/**
 * Convert Min Heap to Max Heap
 * ==============================
 * Given a min-heap in array representation named nums, convert it into a
 * max-heap and return the resulting array.
 * 
 * A min-heap is a complete binary tree where the key at the root is the minimum
 * among all keys present in a binary min-heap and the same property is
 * recursively true for all nodes in the Binary Tree.
 * A max-heap is a complete binary tree where the key at the root is the maximum
 * among all keys present in a binary max-heap and the same property is
 * recursively true for all nodes in the Binary Tree.
 * 
 * Since there can be multiple answers, the compiler will return true if it's
 * correct, else false.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinToMaxHeap09 {
    public static void heapifyDown(int[] nums, int index) {
        int n = nums.length; // total no of nodes

        int largestIndex = index;

        // child nodes of parent at largest index so far
        int leftChildIndex = 2 * largestIndex + 1;
        int rightChildIndex = 2 * largestIndex + 2;

        if (leftChildIndex < n && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < n && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            // perform swap and move the max value to parent location
            int temp = nums[largestIndex];
            nums[largestIndex] = nums[index];
            nums[index] = temp;

            // continue the process
            heapifyDown(nums, largestIndex);
        }
    }

    public static int[] minToMaxHeap(int[] nums) {
        int N = nums.length; // total no of nodes

        // leaf nodes are already in correct place
        // now correct the internal nodes on need
        for (int i = (N / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] minHeap = { 2, 6, 3, 100, 120, 4, 5 };
        int[] result = minToMaxHeap(minHeap);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
