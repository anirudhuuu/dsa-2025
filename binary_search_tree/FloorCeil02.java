package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Floor and Ceil in a BST
 * ===========================
 * Given a root of binary search tree and a key(node) value,
 * find the floor and ceil value for that particular key value.
 *
 * Floor Value Node: Node with the greatest data lesser than or equal to the key value.
 * Ceil Value Node: Node with the smallest data larger than or equal to the key value.
 *
 * If a particular floor or ceil value is not present then output -1.
 *
 * Time Complexity:
 * Balanced Tree - O(log N)
 * Skewed Tree - O(N)
 *
 * Space Complexity: O(1)
 */
public class FloorCeil02 {
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

    int findFloor(Node root, int key) {
        int floor = -1;

        while (root != null) {
            // value is found
            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            // value is not present, find closest
            if (root.data < key) {
                floor = root.data;
                // look for the next bigger value on right side
                root = root.right;
            } else {
                // node holds a bigger value than what you are search
                // hence look for a smaller value on left
                root = root.left;
            }
        }

        return floor;
    }

    int findCeil(Node root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (root.data < key) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
    }

    List<Integer> floorCeilOfBST(Node root, int key) {
        List<Integer> result = new ArrayList<>();

        int floorValue = findFloor(root, key);
        int ceilValue = findCeil(root, key);

        result.add(floorValue);
        result.add(ceilValue);

        return result;
    }

    static void main() {

    }
}
