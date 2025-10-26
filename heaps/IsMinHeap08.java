package heaps;

/**
 * Check if an array represents a min heap
 * ==========================================
 * Given an array of integers nums. Check whether the array represents a binary
 * min-heap or not. Return true if it does, otherwise return false.
 * 
 * A binary min-heap is a complete binary tree where the key at the root is the
 * minimum among all keys present in a binary min-heap and the same property is
 * recursively true for all nodes in a Binary Tree.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class IsMinHeap08 {
    public static boolean isHeap(int[] nums) {
        // no of nodes
        int N = nums.length - 1;

        // iterate on indexes of internal nodes
        // (as leaf nodes are already min heap property)
        for (int i = 0; i <= (N / 2) - 1; i++) {
            // for every parent node check its children
            int leftChildIdx = 2 * i + 1;
            int rightChildIdx = 2 * i + 2;

            if ((nums[leftChildIdx] < nums[i]) || (nums[rightChildIdx] < nums[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5, 7, 9, 11 };
        int[] nums2 = { 10, 15, 20, 30, 40 };
        int[] nums3 = { 10, 9, 20, 30, 40 };

        System.out.println(isHeap(nums1));
        System.out.println(isHeap(nums2));
        System.out.println(isHeap(nums3));
    }
}
