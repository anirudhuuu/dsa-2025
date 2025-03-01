package binary_search.logic_building;

/**
 * Given a sorted array of nums consisting of distinct
 * integers and a target value, return the index if the
 * target is found. If not, return the index where it
 * would be if it were inserted in order.
 */
public class SearchInsert {
    int searchInsertBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    int searchInsert(int[] nums, int target) {
        int answer = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
