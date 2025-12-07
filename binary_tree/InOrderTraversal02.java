package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Inorder Traversal
 * ====================
 * Given root of binary tree, return the Inorder traversal of the binary tree.
 * - These are kind of DFS traversal technique
 * - Left   x Root   x Right
 * - Travel x Access x Travel
 */
public class InOrderTraversal02 {
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
     *
     * In case of balanced binary tree,
     * Space Complexity: O(Log (base 2) N)
     */
    void inorder(Node node) {
        if (node == null) {
            return;
        }

        // travel left
        inorder(node.left);
        // access root
        System.out.print(node.data + " ");
        // travel right
        inorder(node.right);
    }

    /*
     * Iterative way
     * ----------------------
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    List<Integer> inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.empty()) {
                    break;
                }

                node = stack.pop();
                list.add(node.data);
                node = node.right;
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

        new InOrderTraversal02().inorder(root);
        System.out.println();
        List<Integer> result = new InOrderTraversal02().inorderIterative(root);
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
