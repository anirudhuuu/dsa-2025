package heaps;

import java.util.PriorityQueue;

/**
 * K-th Largest element in an array
 * =================================
 * Given an array nums, return the k-th largest element in the array.
 * <p>
 * Time Complexity: O(N * log K)
 * Space Complexity: O(K)
 */
public class KthLargest12 {
    public static int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add the first k-elements in min-heap
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // process the rest of the (N - k) elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                // remove the smallest from min-heap
                pq.poll();

                // add the current element into the min-heap
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        System.out.println("K-th largest :: " + kthLargestElement(nums, 5));
    }
}
