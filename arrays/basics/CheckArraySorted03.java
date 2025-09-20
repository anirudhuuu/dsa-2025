package arrays.basics;

/**
 * Check if the Array is Sorted I
 * =================================
 * Given an array arr of size n, the task is to check if the given array is
 * sorted in (ascending / Increasing / Non-decreasing) order. If the array is
 * sorted then return True, else return False.
 */
public class CheckArraySorted03 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            // if the value on left is greater than right
            // means it is not sorted
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 6, 7, 8 };
        System.out.println(arraySortedOrNot(arr, arr.length));
    }
}
