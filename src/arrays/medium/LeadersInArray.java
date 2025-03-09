package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an integer array nums, return a list of all
 * the leaders in the array.
 * <p>
 * A leader in an array is an element whose value is strictly
 * greater than all elements to its right in the given array.
 * The rightmost element is always a leader. The elements in the
 * leader array must appear in the order they appear in the nums array.
 */
public class LeadersInArray {
    ArrayList<Integer> leadersBrute(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int leader = nums[i];
            boolean isLeader = true;

            for (int j = i + 1; j < nums.length; j++) {
                if (leader < nums[j]) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader) {
                if (!result.contains(leader)) {
                    result.add(leader);
                }
            }
        }

        return result;
    }

    ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int max = nums[nums.length - 1];
        result.add(max);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                if (!result.contains(max)) {
                    result.add(max);
                }
            }
        }

        Collections.reverse(result);

        return result;
    }
}
