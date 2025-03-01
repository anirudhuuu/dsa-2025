package binary_search;

/**
 * Given a sorted array of integers nums with 0-based indexing, find the index
 * of a specified target integer.
 * <p>
 * If the target is found in the array,
 * return its index. If the target is not found, return -1.
 */
public class SearchX {
    int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }

    int searchRec(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchRec(nums, mid + 1, high, target);
        } else if (nums[mid] > target) {
            return searchRec(nums, low, mid + 1, target);
        }

        return -1;
    }

    int searchRecursive(int[] nums, int target) {
        return searchRec(nums, 0, nums.length - 1, target);
    }
}
