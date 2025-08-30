package monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element - 2
 * ===========================
 * Given a circular integer array arr, return the next greater element for every
 * element in arr.
 * 
 * The next greater element for an element x is the first element greater than x
 * that we come across while traversing the array in a clockwise manner.
 * 
 * If it doesn't exist, return -1 for that element element.
 */
public class NextGreaterElement02 {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }

            if (i < n) {
                nge[i] = stack.empty() ? -1 : stack.peek();
            }

            stack.push(arr[i % n]);
        }

        return nge;
    }

    public static int[] nextGreaterElementsBrute(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        for (int start = 0; start < n; start++) {
            int current = arr[start];

            for (int offset = 1; offset < n; offset++) {
                int lookIndex = (start + offset) % n;

                if (arr[lookIndex] > current) {
                    nge[start] = arr[lookIndex];
                    break;
                }
            }
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9 };
        int[] result1 = nextGreaterElementsBrute(arr1);

        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] arr2 = { 5, 7, 1, 7, 6, 0 };
        int[] result2 = nextGreaterElementsBrute(arr2);

        for (int val : result2) {
            System.out.print(val + " ");
        }
    }
}
