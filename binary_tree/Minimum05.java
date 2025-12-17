package binary_tree;

/*
 * Minimum in Binary Tree
 * =======================
 * Find the smallest value in a given binary tree root node
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
public class Minimum05 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int minimumInTree(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int minFromLeft = minimumInTree(root.left);
        int minFromRight = minimumInTree(root.right);

        return Math.min(Math.min(minFromLeft, minFromRight), root.data);
    }

    static void main() {
        Node n1 = new Node(10);
        Node n2 = new Node(4);
        Node n3 = new Node(20);
        Node n4 = new Node(3);
        Node n5 = new Node(7);
        Node n6 = new Node(5);

        Node root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println("Minimum value :: " + new Minimum05().minimumInTree(root));
    }
}
