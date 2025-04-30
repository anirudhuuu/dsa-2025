package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums of size n. Return all elements which
 * appear more than n/3 times in the array.
 * <p>
 * The output can be returned in any order.
 */
public class MajorityElement2 {
    // Brute force algo (but will lead to Time limit exceed
    List<Integer> majorityElementTwoBrute(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (element == nums[j]) {
                    count += 1;
                }
            }
            if (count > (nums.length / 3)) {
                if (!result.contains(element)) {
                    result.add(element);
                }
            }
        }

        return result;
    }

    // Brute force algo with optimization
    List<Integer> majorityElementTwoBrute2(int[] nums) {
        /*
         * A majority element in this context is defined as an element that appears
         * more than n/3 times in the array. For an element to be a majority element,
         * it must appear more than n/3 times. Let's assume there are more than
         * two such majority elements. Let's denote these elements as A, B, and C.
         *
         * Since each of these elements appears more than n/3 times, the combined
         * frequency of these three elements would be:
         * frequency of 𝐴 + frequency of 𝐵 + frequency of 𝐶 > 𝑛/3 + 𝑛/3 + 𝑛/3 = 𝑛
         *
         * Now, the total number of occurrences of all elements in the array
         * cannot exceed n, the size of the array. This means the combined
         * frequency of any three elements each appearing more than n/3
         * times would exceed the total size of the array, which is a
         * contradiction. Therefore, it's mathematically impossible for
         * there to be more than two elements in the array that each
         * appear more than n/3 times
         */
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (result.size() == 0 || result.get(0) != nums[i]) {
                int element = nums[i];
                int count = 0;

                for (int j = 0; j < nums.length; j++) {
                    if (element == nums[j]) {
                        count += 1;
                    }
                }

                if (count > (nums.length / 3)) {
                    if (!result.contains(element)) {
                        result.add(element);
                    }
                }
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    // Best algo
    List<Integer> majorityElementTwoBest(int[] nums) {
        List<Integer> result = new ArrayList<>();
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

            if (value > (nums.length / 3)) {
                if (!result.contains(key)) {
                    result.add(key);
                }
            }
        }

        return result;
    }

    // Best algo with optimisation
    List<Integer> majorityElementTwoBest2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int mini = (nums.length / 3) + 1;

        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

            if (frequency.get(nums[i]) == mini) {
                result.add(nums[i]);
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    // Optimised algo
    static List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        // Boyer Moore's Voting Algorithm
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && element1 != nums[i]) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1 += 1;
            } else if (nums[i] == element2) {
                count2 += 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1 += 1;
            }

            if (nums[i] == element2) {
                count2 += 1;
            }
        }

        int mini = ((nums.length) / 3) + 1;

        if (count1 >= mini) {
            result.add(element1);
        }

        if (count2 >= mini && element1 != element2) {
            result.add(element2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 2, 2};

        List<Integer> result = majorityElementTwo(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
