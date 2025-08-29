package monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element
 * =====================
 * Given an array arr of size n containing elements, find the next greater
 * element for each element in the array in the order of their appearance.
 * 
 * The next greater element of an element in the array is the nearest element on
 * the right that is greater than the current element.
 * 
 * If there does not exist a next greater element for the current element, then
 * the next greater element for that element is -1.
 */
public class NextGreaterElement01 {
    // Optimal approach
    public static int[] nextLargerElement(int[] arr) {
        int[] nge = new int[arr.length];
        Arrays.fill(nge, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from stack while stack top is less than or equal to arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is not empty, then the top is the next greater element
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }

            // Push current element to stack for next iteration
            stack.push(arr[i]);
        }

        return nge;
    }

    // Brute force approach
    public static int[] nextLargerElementBrute(int[] arr) {
        int[] nge = new int[arr.length];
        Arrays.fill(nge, -1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    nge[i] = arr[j];
                    break;
                }
            }
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 2, 4 };
        int[] result1 = nextLargerElementBrute(arr1);

        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] arr2 = { 6, 8, 0, 1, 3 };
        int[] result2 = nextLargerElement(arr2);
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
