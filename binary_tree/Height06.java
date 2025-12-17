package binary_tree;

/*
 * Height of a Binary Tree
 * ==========================
 * Find the height of a given Binary tree. Height is defined
 * as the farthest distance of any node from the root node.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
public class Height06 {
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

    int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight = heightOfTree(root.left);
        int rightTreeHeight = heightOfTree(root.right);

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
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

        System.out.println("Height of given tree :: " + new Height06().heightOfTree(root));
    }
}
