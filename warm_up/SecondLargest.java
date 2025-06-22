package warm_up;

public class SecondLargest {
    static double secondLargestNumber(int[] arr) {
        /**
         * ASK
         * ===
         * what if array is empty?
         * what if array has only 1 element?
         * do we have negative numbers in input?
         * what if we have duplicate numbers in input?
         */
        if (arr.length < 2) {
            // array should have minimum of 2 values
            return -1;
        }

        double largest = Double.NEGATIVE_INFINITY;
        double secondLargest = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                // improvement for "what if we have duplicate numbers in input?"
                secondLargest = arr[i];
            }

            /**
             * else if (arr[i] > secondLargest) {
             * secondLargest = arr[i];
             * }
             */
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 9, 9, 0, 2, 8, 7, 1 };
        double result = secondLargestNumber(arr);
        System.out.println(result);
    }
}
