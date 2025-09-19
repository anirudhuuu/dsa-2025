package sorting;

/**
 * Selection Sort
 * ===============
 * Given an array of integers nums, sort the array in non-decreasing order using
 * the selection sort algorithm and return the sorted array.
 */
public class SelectionSort01 {
    /**
     * Find the minimum value and swap
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // location where sorted value goes
            int minIndex = i;

            // search for minimum value in the list
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // update the minimum value's location with swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 1, 5, 3 };
        selectionSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
