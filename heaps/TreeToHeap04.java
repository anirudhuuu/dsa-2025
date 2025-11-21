package heaps;

public class TreeToHeap04 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int[] nums = new int[7];

    void heapifyDown(int[] nums, int index) {
        int n = nums.length;

        // index of smallest element
        int smallestIndex = index;

        // indexes of left/right children
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has the smallest value, update the smallest index
        if (leftChildIndex < n && nums[leftChildIndex] < nums[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        // if the right child has the smallest value, update the smallest index
        if (rightChildIndex < n && nums[rightChildIndex] < nums[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        // if we find a small value in the children, then swap
        if (smallestIndex != index) {
            // swap the smallest element with the current index
            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[index];
            nums[index] = temp;

            heapifyDown(nums, smallestIndex);
        }
    }

    void buildMinHeap(int[] nums) {
        int noOfNodes = nums.length;

        // on all the internal nodes
        for (int i = noOfNodes / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
    }

    void build(TreeNode node, int index) {
        nums[index] = node.val;

        if (node.left != null) {
            build(node.left, 2 * index + 1);
        }

        if (node.right != null) {
            build(node.right, 2 * index + 2);
        }
    }

    static void main() {
        TreeNode root = new TreeNode(100);

        // left of root
        root.left = new TreeNode(10);

        // right of root
        root.right = new TreeNode(8);

        // 10's children
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(20);

        // 8's children
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);

        // root node ---> "root"
        new TreeToHeap04().build(root, 0);

        System.out.println("Tree to Array Output :: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // just on the internal nodes perform heapify
        new TreeToHeap04().buildMinHeap(nums);

        System.out.println("Heapify Output :: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
