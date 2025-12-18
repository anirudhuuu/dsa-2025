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
class Search01 {
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

    Node searchBST(Node root, int key) {
        if (root == null)
            return null;

        if (root.data > key)
            return searchBST(root.left, key);

        if (root.data < key)
            return searchBST(root.right, key);

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

        Search01 s = new Search01();
        Node find4 = s.searchBST(root, 4);
        Node find10 = s.searchBST(root, 10);

        System.out.println("Search for 4 :: " + find4.data);
        System.out.println("Search for 10 :: " + (find10 == null ? "Not found" : find10.data));
    }
}
