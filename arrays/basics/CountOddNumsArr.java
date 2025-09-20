package arrays.basics;

/**
 * Given an array of n elements. The task is to return the count of
 * the number of odd in the array.
 */
public class CountOddNumsArr {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    int countOdd(int[] arr, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count += 1;
            }
        }

        return count;
    }
}
