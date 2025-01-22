package basics.arrays;

/**
 * Given an array arr of size n, the task is to check if the given
 * array is sorted in (ascending / Increasing / Non-decreasing) order.
 * <p>
 * If the array is sorted then return True, else return False.
 */
public class CheckArraySorted {
    public boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }
}
