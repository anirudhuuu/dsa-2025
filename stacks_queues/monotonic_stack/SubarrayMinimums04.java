package monotonic_stack;

/**
 * Sum of Subarray Minimums
 * ===========================
 * Given an array of integers arr of size n, calculate the sum of the minimum
 * value in each (contiguous) subarray of arr. Since the result may be large,
 * return the answer modulo 10^9 +7.
 */
public class SubarrayMinimums04 {
    // public static int sumSubarrayMins(int[] arr) {
    // return 0;
    // }

    public static int sumSubarrayMinsBrute(int[] arr) {
        int resultSum = 0;
        int n = arr.length;
        int modValue = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int minimumValue = arr[i];
            for (int j = i; j < n; j++) {
                minimumValue = Math.min(minimumValue, arr[j]);
                resultSum = (resultSum + minimumValue) % modValue;
            }
        }

        return resultSum;
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 1, 2, 5 };
        System.out.println(sumSubarrayMinsBrute(arr1));

        // int[] arr2 = { 2, 3, 1 };
        // System.out.println(sumSubarrayMins(arr2));
    }
}
