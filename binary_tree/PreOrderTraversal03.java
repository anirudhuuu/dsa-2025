package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Preorder Traversal
 * ====================
 * Given root of binary tree, return the preorder traversal of the binary tree.
 * - These are kind of DFS traversal technique
 * - Root   x Left   x Right
 * - Access x Travel x Travel
 */
public class PreOrderTraversal03 {
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

    /*
     * Recursive way
     * ----------------------
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * - N no of nodes
     */
    void preorder(Node node) {
        if (node == null) {
            return;
        }

        // access root
        System.out.print(node.data + " ");
        // travel left
        preorder(node.left);
        // travel right
        preorder(node.right);
    }

    List<Integer> preorderIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(node);

        while (stack.empty() == false) {
            // access root
            node = stack.pop();
            list.add(node.data);

            /*
             * travel right, Why?
             *
             * Preorder = Root → Left → Right
             *
             * A stack is LIFO (Last In, First Out).
             * So the last thing you push is the first thing that comes out.
             */
            if (node.right != null) {
                stack.push(node.right);
            }

            // travel left
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    static void main() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        new PreOrderTraversal03().preorder(root);
        System.out.println();
        List<Integer> result = new PreOrderTraversal03().preorderIterative(root);
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
