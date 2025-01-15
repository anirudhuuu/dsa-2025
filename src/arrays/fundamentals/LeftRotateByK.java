package arrays.fundamentals;

public class LeftRotateByK {
    public static void rotateArrayBrute(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[k];
        // Get the copy of the first k elements
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        // Copying the rest values to left position
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        // Keep the temp back in the array
        /**
         * int j = 0;
         *
         * for (int i = n - k; i < n; i++) {
         *      nums[i] = temp[j];
         *      j += 1;
         * }
         */
        for (int i = n-k; i < n; i++) {
            nums[i] = temp[i - (n-k)];
        }

        // Result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start += 1;
            end -= 1;
        }
    }

    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverseArray(nums, 0, k - 1);

        reverseArray(nums, k, n - 1);

        reverseArray(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        rotateArray(nums, 3);
    }
}
