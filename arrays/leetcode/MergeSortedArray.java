package arrays.leetcode;

/**
 * Merge Sorted Array
 * =====================
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length
 * of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 */
class MergeSortedArray {
    void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] mergedArr = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArr[k] = nums1[i];

                i += 1;
            } else {
                mergedArr[k] = nums2[j];

                j += 1;
            }

            k += 1;
        }

        while (i < m) {
            mergedArr[k] = nums1[i];

            i += 1;
            k += 1;
        }

        while (j < n) {
            mergedArr[k] = nums2[j];

            j += 1;
            k += 1;
        }

        for (int itr = 0; itr < m + n; itr++) {
            nums1[itr] = mergedArr[itr];
        }
    }
}
