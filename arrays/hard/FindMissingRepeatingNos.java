package arrays.hard;

/**
 * Given an integer array nums of size n containing values from [1, n]
 * and each value appears exactly once in the array, except for A,
 * which appears twice and B which is missing.
 * <p>
 * Return the values A and B, as an array of size 2,
 * where A appears in the 0-th index and B in the 1st index.
 */
public class FindMissingRepeatingNos {
    // Brute force algorithm
    int[] findMissingRepeatingNumbersBrute(int[] nums) {
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count += 1;
                }
            }

            if (count == 2) {
                repeating = i;
            } else if (count == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    // Best algorithm
    static int[] findMissingRepeatingNumbers(int[] nums) {
        int[] hash = new int[nums.length + 1];

        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] += 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        int[] result = findMissingRepeatingNumbers(arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
