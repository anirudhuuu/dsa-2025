package arrays.basics;

/**
 * Reverse an array
 * ==================
 * Given an array arr of n elements. The task is to reverse
 * the given array. The reversal of array should be in-place.
 */
public class ReverseArray04 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverse(int[] arr, int n) {
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 5, 1 };
        reverse(arr, arr.length);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
