package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * Postorder Traversal
 * ====================
 * Given root of binary tree, return the Postorder traversal of the binary tree.
 *
 * - These are kind of DFS traversal technique
 * - Left   x Right  x Root
 * - Travel x Travel x Access
 */
public class PostOrderTraversal04 {
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
    void postorder(Node node) {
        if (node == null) {
            return;
        }

        // travel left
        postorder(node.left);
        // travel right
        postorder(node.right);
        // access root
        System.out.print(node.data + " ");
    }

    List<Integer> postorderIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(node);

        while (stack.empty() == false) {
            // access root
            node = stack.pop();
            list.add(node.data);

            // travel left
            if (node.left != null) {
                stack.push(node.left);
            }

            // travel right
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        /*
         * Because the algorithm is actually generating
         * a "Root → Right → Left" traversal, and
         * reversing it converts that order into the true
         * Left → Right → Root postorder traversal.
         */
        Collections.reverse(list);

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

        new PostOrderTraversal04().postorder(root);
        System.out.println();
        List<Integer> result = new PostOrderTraversal04().postorderIterative(root);
        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }
}
