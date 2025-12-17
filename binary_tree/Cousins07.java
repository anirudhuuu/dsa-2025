package binary_tree;

/*
 * Cousins in a Binary Tree
 * =============================
 * Given the root of a binary tree with unique values
 * and the values of two different nodes of the tree x and y,
 * return tree if the nodes corresponding to the values x and y
 * in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the
 * same depth with different parents.
 */
public class Cousins07 {
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

    private Node xParent, yParent;
    private int xLevel, yLevel;

    public Cousins07() {
        this.xParent = null;
        this.yParent = null;
        this.xLevel = -1;
        this.yLevel = -1;
    }

    void areCousinsHelper(Node current, Node parent, int x, int y, int level) {
        if (current == null) {
            return;
        }

        if (current.data == x) {
            xParent = parent;
            xLevel = level;
        }

        if (current.data == y) {
            yParent = parent;
            yLevel = level;
        }

        areCousinsHelper(current.left, current, x, y, level + 1);
        areCousinsHelper(current.right, current, x, y, level + 1);
    }

    boolean areCousins(Node root, int x, int y) {
        // root can never be a cousin
        if (root == null || root.data == x || root.data == y) {
            return false;
        }

        areCousinsHelper(root, null, x, y, 0);

        if (xParent == null || yParent == null) {
            return false;
        }

        boolean onSameLevel = xLevel == yLevel;
        boolean differentParents = xParent != yParent;

        return onSameLevel && differentParents;
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

        System.out.println("Are cousins (10, 20)? " + new Cousins07().areCousins(root, 10, 20));
        System.out.println("Are cousins (7, 5)? " + new Cousins07().areCousins(root, 7, 5));
        System.out.println("Are cousins (3, 5)? " + new Cousins07().areCousins(root, 3, 5));
    }
}
