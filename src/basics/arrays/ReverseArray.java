package basics.arrays;

/**
 * Given an array arr of n elements. The task is to reverse
 * the given array. The reversal of array should be in-place.
 */
public class ReverseArray {
    public void reverse(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low += 1;
            high -= 1;
        }
    }
}
