package binary_search_tree;

/*
 * Search in BST
 * =================
 * Given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return
 * the subtree rooted with that node. If such a node does not exist, return null.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class SearchBST01 {
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

    Node searchBST(Node root, int val) {
        while (root != null && root.data != val) {
            if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    static void main() {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println("Search for 4 :: " + new SearchBST01().searchBST(root, 4));
        System.out.println("Search for 10 :: " + new SearchBST01().searchBST(root, 10));
    }
}
