package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Power Set
 * ============
 * Given an array of integers nums of unique elements. Return all possible
 * subsets (power set) of the array.
 * 
 * Do not include the duplicates in the answer.
 */
public class PowerSet {
    public static void generateSubsets(
            int index,
            List<Integer> current,
            List<List<Integer>> result,
            int[] nums,
            int N) {

        if (index == N) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element in the subset and move to the next element
        current.add(nums[index]);
        generateSubsets(index + 1, current, result, nums, N);
        current.remove(current.size() - 1);

        // Exclude the current element and move to the next element
        generateSubsets(index + 1, current, result, nums, N);
    }

    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generateSubsets(0, current, result, nums, nums.length);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.err.println(powerSet(nums));
    }
}
