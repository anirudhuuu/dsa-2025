package arrays.basics;

/**
 * Count of odd numbers in array
 * ==============================
 * Given an array of n elements. The task is to return the count of
 * the number of odd in the array.
 */
public class CountOddNumsArr02 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countOdd(int[] arr, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 5, 1 };
        System.out.println(countOdd(arr, arr.length));
    }
}
