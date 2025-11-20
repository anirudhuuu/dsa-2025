package heaps;

/*
 * Heaps
 * =======
 * A heap is a specialized, tree-based data structure.
 *
 * It implements an abstract data type called the Priority Queue,
 * but sometimes 'Heap' and 'Priority Queue' are used interchangeably.
 *
 * There are two types of heaps:
 * 1. Min heaps have the smallest value at the root node.
 * The smallest value has the highest priority to be removed.
 *
 * 2. Max heaps have the largest value at the root node.
 * The largest value has the highest priority to be removed.
 *
 * Heap Properties
 * ================
 * For a binary tree to qualify as a heap, it must satisfy the following properties:
 *
 * 1. Structure Property:
 * A heap is a binary tree that is a complete binary tree, where
 * every single level of the tree is filled completely, except possibly the lowest level nodes,
 * which are filled contiguously from left to right.
 *
 * 2. Order Property:
 * The order property for a min-heap is that all the descendants should be
 * greater than their ancestors.
 *
 * Unlike binary search trees, heaps may contain "duplicate values".
 *
 * For a heap to be represented on a 0-index based array, a node at given index "i" has:
 * - left child is at index (2*i + 1) and
 * - right child is at index (2*i + 2)
 *
 * The parent of a node at index "i" is at index floor of [(i - 1) / 2].
 *
 * index of leaf nodes = {n/2, n/2 + 1, ..., n-1}
 * index of non-leaf nodes = {0, 1, 2, ..., n/2 - 1}
 *
 * No of internal nodes = (leaf nodes) - 1
 */

public class Heaps01 {
    static void main() {
        int n = 11;

        int leafNodes = n / 2;
        int internalNodes = n - leafNodes;

        System.out.println("No of nodes (n): " + n);
        System.out.println("No of leaf nodes (leafNodes): " + leafNodes);
        System.out.println("No of internal nodes (n - leafNodes): " + internalNodes);
    }
}
