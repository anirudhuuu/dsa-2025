package arrays.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums of size n, return the majority element of the array.
 * <p>
 * The majority element of an array is an element that appears more
 * than n/2 times in the array. The array is guaranteed to have a majority element.
 */
public class MajorityElement1 {
    public static int majorityElementBrute(int[] nums) {
        int majorityElement = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int searchElement = nums[i];

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == searchElement) {
                    count += 1;
                }
            }

            if (count > (nums.length / 2)) {
                majorityElement = searchElement;
                break;
            }
        }

        return majorityElement;
    }

    public static int majorityElementBest(int[] nums) {
        int majorityElement = 0;

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (frequency.get(nums[i]) == null) {
                frequency.put(nums[i], 1);
            } else {
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > (nums.length / 2)) {
                majorityElement = key;
                break;
            }
        }

        return majorityElement;
    }

    public static int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (element == nums[i]) {
                count += 1;
            } else if (element != nums[i]) {
                count -= 1;
            }
        }

        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count += 1;
            }
        }

        if (count > (nums.length / 2)) {
            return element;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElement(arr));
    }
}
