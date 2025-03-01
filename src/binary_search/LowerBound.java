package binary_search;

/**
 * Given a sorted array of nums and an integer x,
 * write a program to find the lower bound of x.
 * <p>
 * The lower bound algorithm finds the first or the smallest index in a sorted array
 * where the value at that index is greater than or equal to a given key i.e. x.
 * <p>
 * If no such index is found, return the size of the array.
 */
public class LowerBound {
    int lowerBoundBrute(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x) {
                return i;
            }
        }

        return nums.length;
    }

    int lowerBound(int[] nums, int x) {
        int answer = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
