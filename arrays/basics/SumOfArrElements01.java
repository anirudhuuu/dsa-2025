package arrays.basics;

/**
 * Sum of Array Elements
 * ========================
 * Given an array arr of size n, the task is to find the
 * sum of all the elements in the array.
 */
public class SumOfArrElements01 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sum(int arr[], int n) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(sum(arr, arr.length));
    }
}
