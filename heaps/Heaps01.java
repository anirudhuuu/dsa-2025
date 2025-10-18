package heaps;

/**
 * Heaps
 * =====================
 * Heaps are internal implementations of priority queues.
 * They are almost complete binary trees that satisfy the heap property.
 * 
 * There are two types of heaps:
 * 1. Min-heap: The parent node is less than or equal to the child nodes.
 * 2. Max-heap: The parent node is greater than or equal to the child nodes.
 * 
 * For a given index i, the left child is at index 2*i + 1 and the right child
 * is at index 2*i + 2.
 * 
 * The parent of a node at index i is at index (i - 1) / 2.
 * 
 * index of leaf nodes = {n/2, n/2 + 1, ..., n-1}
 * index of non-leaf nodes = {0, 1, 2, ..., n/2 - 1}
 * 
 * No of internal nodes = (leaf nodes) - 1
 */

public class Heaps01 {
    public static void main(String[] args) {
        int n = 10;

        int leafNodes = n / 2;
        int internalNodes = n - leafNodes;

        System.out.println("No of leaf nodes: " + leafNodes);
        System.out.println("No of internal nodes: " + internalNodes);
        System.out.println("No of nodes: " + n);
    }
}
