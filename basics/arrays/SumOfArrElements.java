package basics.arrays;

/**
 * Given an array arr of size n, the task is to find the
 * sum of all the elements in the array.
 */
public class SumOfArrElements {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    int sum(int arr[], int n) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += arr[i];
        }

        return result;
    }
}
