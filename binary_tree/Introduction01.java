package binary_tree;

/**
 * Binary Tree
 * ==============
 * A tree data structure in which each parent node can have at most two
 * children. Each node of a binary tree consists of three items:
 * - data item
 * - address to left child
 * - address to right child
 */
public class Introduction01 {
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

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
    }
}
