package heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement Min Heap
 * =====================
 * You need to implement the Min Heap with the following given methods.
 *
 * - insert(x) -> insert value x to the min heap
 *
 * - getMin() -> Output the minimum value from the min heap
 *
 * - exctractMin() -> Remove the minimum element from the heap
 *
 * - heapSize() -> return the current size of the heap
 *
 * - isEmpty() -> returns if heap is empty or not
 *
 * - changeKey(ind, val) -> update the value at given
 *   index to val (index will be given 0-based indexing)
 *
 * - initializeHeap() -> Initialize the heap
 */
public class ImplementMinHeap07 {
    private static List<Integer> arr;
    private static int count;

    public ImplementMinHeap07() {
        arr = new ArrayList<>();
        count = 0;
    }

    void initializeHeap() {
        arr = new ArrayList<>();
        count = 0;
    }

    void insert(int key) {
        arr.add(key);
        heapifyUp(count);
        count = count + 1;
    }

    void changeKey(int index, int newVal) {
        if (arr.get(index) < newVal) {
            // adding a value more than existing value
            // we might need to move the large value DOWN as its min-heap
            arr.set(index, newVal);
            heapifyDown(index);
        } else {
            // adding a value less than existing value
            // we might need to move the smaller value UP as its min-heap
            arr.set(index, newVal);
            heapifyUp(index);
        }
    }

    void extractMin() {
        if (count == 0)
            return;

        // swap the first element with last and remove last (min)
        int temp = arr.get(0);
        arr.set(0, arr.get(count - 1));
        arr.set(count - 1, temp);

        // pop the minimum value from the list
        arr.remove(count - 1);
        count = count - 1;

        if (count > 0) {
            heapifyDown(0);
        }
    }

    boolean isEmpty() {
        return (count == 0);
    }

    int getMin() {
        return arr.get(0);
    }

    int heapSize() {
        return count;
    }

    void heapifyUp(int index) {
        // find parent's index
        int parentIndex = (index - 1) / 2;

        // if current value that is added; holds a smaller value than its parent
        // it means it shall go up to where parent is present
        if (index > 0 && arr.get(index) < arr.get(parentIndex)) {
            // swap current value and parent
            int temp = arr.get(index);
            arr.set(index, arr.get(parentIndex));
            arr.set(parentIndex, temp);

            // recursively heapify the upper nodes
            heapifyUp(parentIndex);
        }
    }

    void heapifyDown(int index) {
        int n = count;

        int smallestIndex = index;

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has smaller value then take that
        if (leftChildIndex < n && arr.get(leftChildIndex) < arr.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }

        // if the right child has smaller value then take that
        if (rightChildIndex < n && arr.get(rightChildIndex) < arr.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }

        // once the smaller element is found
        if (smallestIndex != index) {
            // swap the latest smaller value to the node where it shall be
            int temp = arr.get(smallestIndex);
            arr.set(smallestIndex, arr.get(index));
            arr.set(index, temp);

            // recursively heapify the bottom nodes
            heapifyDown(smallestIndex);
        }
    }

    static void main() {
        // 1. initializeHeap
        System.out.println("=== initializeHeap ===");
        ImplementMinHeap07 minHeap = new ImplementMinHeap07();

        // 2. insert 4
        System.out.println("insert 4");
        minHeap.insert(4);

        // 3. insert 1
        System.out.println("insert 1");
        minHeap.insert(1);

        // 4. insert 10
        System.out.println("insert 10");
        minHeap.insert(10);

        // 5. getMin
        System.out.println("getMin: " + minHeap.getMin()); // 1

        // 6. heapSize
        System.out.println("heapSize: " + minHeap.heapSize()); // 3

        // 7. isEmpty (print 1 if empty, 0 if not empty)
        System.out.println("isEmpty: " + minHeap.isEmpty()); // false

        // 8. extractMin
        System.out.println("extractMin");
        minHeap.extractMin();

        // 9. changeKey at index 0 to 16
        System.out.println("changeKey idx = 0 to 16: ");
        minHeap.changeKey(0, 16);

        // 10. getMin
        System.out.println("getMin: " + minHeap.getMin()); // 10
    }
}
