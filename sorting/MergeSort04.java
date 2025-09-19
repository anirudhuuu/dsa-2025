package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Sort
 * ============
 * Given an array of integers, nums,sort the array in non-decreasing order using
 * the merge sort algorithm. Return the sorted array.
 */
public class MergeSort04 {
    /**
     * Much more optimised algorithm compared to other that we saw uptill now
     * Divide and merge
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left += 1;
            } else {
                temp.add(nums[right]);
                right += 1;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left += 1;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right += 1;
        }

        // Copy the sorted elements back into the original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static void mergeSortAlgo(int[] nums, int low, int high) {
        // when divided array of nums is of single value
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSortAlgo(nums, low, mid);
        mergeSortAlgo(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    public static int[] mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        mergeSortAlgo(nums, low, high);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        int[] result = mergeSort(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
