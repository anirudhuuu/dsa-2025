package heaps;

import java.util.PriorityQueue;

/**
 * Kth largest element in a stream of running integers
 * ======================================================
 * Implement a class KthLargest to find the kth largest number in a stream. It
 * should have the following methods:
 * 
 * - K thLargest(int k, int [] nums) Initializes the object with the integer k
 * and the initial stream of numbers in nums
 * - int add(int val) Appends the integer val to the stream and returns the kth
 * largest element in the stream.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 */
public class KthLargest12 {
    private int K;
    private PriorityQueue<Integer> pq;

    public KthLargest12(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            // If the size of min-heap is less than k
            if (pq.size() < K) {
                // Add the current element
                pq.offer(nums[i]);
            }

            else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        // If the size of the queue is less than K
        if (pq.size() < K) {
            pq.offer(val);

            return pq.peek();
        }

        // If the smallest element is less than the element to be added
        if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1, 2, 3, 4 };

        // Creating an object of KthLargest class
        KthLargest12 kthLargest = new KthLargest12(k, nums);

        // Performing different operations
        System.out.println("Kth Largest element after adding 5 is: " + kthLargest.add(5));
        System.out.println("Kth Largest element after adding 2 is: " + kthLargest.add(2));
        System.out.println("Kth Largest element after adding 7 is: " + kthLargest.add(7));
    }
}
