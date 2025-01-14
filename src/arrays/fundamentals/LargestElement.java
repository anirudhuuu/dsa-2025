package arrays.fundamentals;

public class LargestElement {
    public static int largestElement(int[] nums) {
        int largestElement = nums[0];

        for (int num : nums) {
            largestElement = Math.max(largestElement, num);
        }

        return largestElement;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 6, 1};

        System.out.println(largestElement(nums));
    }
}
