package arrays.logic_building;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesFromSorted {
    public static int removeDuplicatesBrute(int[] nums) {
        // To store values in order of insertion
        Set<Integer> set = new TreeSet<>();

        // Iterate over entire data of nums
        for (int num : nums) {
            set.add(num);
        }

        int noOfElements = set.size();

        int j = 0;
        for (int val : set) {
            nums[j] = val;
            j += 1;
        }

        // Print the final array
        for (int num : nums) {
            System.out.print(num + " ");
        }

        return noOfElements;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i += 1;
            }
        }

        // Print the final array
        for (int num : nums) {
            System.out.print(num + " ");
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};

        System.out.println("\nSize :: " + removeDuplicatesBrute(nums));
        System.out.println("\nSize :: " + removeDuplicates(nums));
    }
}
