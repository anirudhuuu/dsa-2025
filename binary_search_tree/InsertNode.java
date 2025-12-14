package binary_search_tree;

/*
 * Insert a given node in BST
 * =============================
 * Given the root node of a binary search tree (BST) and a value val to insert
 * into the tree. Return the root node of the BST after the insertion.
 *
 * It is guaranteed that the new value does not exist in the original BST.
 * Note that the compiler output shows true if the node is added correctly, else false.
 */
public class InsertNode {
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

    Node insertIntoBST(Node root, int val) {
        // Tree is empty
        if (root == null) {
            return new Node(val);
        }

        Node current = root;

        while (true) {
            if (current.data <= val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(val);
                    break;
                }
            }
        }

        return root;
    }

    static void main() {

    }
}
