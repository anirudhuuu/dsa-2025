package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

/**
 * Intersection of two sorted arrays
 * =================================
 * Given two sorted arrays nums1 and nums2, return an array containing the
 * intersection of these two arrays.
 * 
 * The intersection of two arrays is an array where all values are present in
 * both arrays.
 */
public class IntersectionOfSortedArrays05 {
    /**
     * Time Complexity: O(n1 * n2)
     * Space Complexity: O(n)
     */
    public static int[] intersectionArrayBrute(int[] nums1, int[] nums2) {
        List<Integer> answer = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] visited = new int[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j] && visited[j] == 0) {
                    answer.add(nums1[i]);
                    visited[j] = 1;
                    break;
                }

                // If the current element in nums2 is greater than
                // the current element in nums1,
                // we can break out of the inner loop
                if (nums2[j] > nums1[i]) {
                    break;
                }
            }
        }

        // Convert list to array
        return answer.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> answer = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                answer.add(nums1[i]);
                i += 1;
                j += 1;
            }
        }

        return answer.stream().mapToInt(val -> val).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 3, 4, 5, 6, 7 };

        int[] result1 = intersectionArrayBrute(nums1, nums2);
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] result2 = intersectionArray(nums1, nums2);
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
