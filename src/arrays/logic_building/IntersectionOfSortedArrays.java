package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
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

                if (nums2[j] > nums1[i]) {
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

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
        int[] nums1 = {1, 2, 2, 3, 5};
        int[] nums2 = {1, 2, 7};

        int[] result1 = intersectionArrayBrute(nums1, nums2);

        for (int num : result1) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] nums3 = {-45, -45, 0, 0, 2};
        int[] nums4 = {-50, -45, 0, 0, 5, 7};

        int[] result2 = intersectionArray(nums3, nums4);

        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
