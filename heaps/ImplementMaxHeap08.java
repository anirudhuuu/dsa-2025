package heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement Max Heap
 * =====================
 * You need to implement the Max Heap with the following given methods.
 *
 * - insert(x) -> insert value x to the max heap
 *
 * - getMax() -> Output the maximum value from the max heap
 *
 * - exctractMax() -> Remove the maximum element from the heap
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
public class ImplementMaxHeap08 {
    private static List<Integer> arr;
    private static int count;

    public ImplementMaxHeap08() {
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
            // we might need to move the large value UP as its max-heap
            arr.set(index, newVal);
            heapifyUp(index);
        } else {
            // adding a value less than existing value
            // we might need to move the smaller value DOWN as its max-heap
            arr.set(index, newVal);
            heapifyDown(index);
        }
    }

    void extractMax() {
        if (count == 0)
            return;

        // swap the first element with last and remove last (max)
        int temp = arr.get(0);
        arr.set(0, arr.get(count - 1));
        arr.set(count - 1, temp);

        // pop the maximum value from the list
        arr.remove(count - 1);
        count = count - 1;

        if (count > 0) {
            heapifyDown(0);
        }
    }

    boolean isEmpty() {
        return (count == 0);
    }

    int getMax() {
        return arr.get(0);
    }

    int heapSize() {
        return count;
    }

    void heapifyUp(int index) {
        // find parent's index
        int parentIndex = (index - 1) / 2;

        // if current value that is added; holds a larger value than its parent
        // it means it shall go up to where parent is present
        if (index > 0 && arr.get(index) > arr.get(parentIndex)) {
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

        int largestIndex = index;

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // if the left child has larger value then take that
        if (leftChildIndex < n && arr.get(leftChildIndex) > arr.get(largestIndex)) {
            largestIndex = leftChildIndex;
        }

        // if the right child has larger value then take that
        if (rightChildIndex < n && arr.get(rightChildIndex) > arr.get(largestIndex)) {
            largestIndex = rightChildIndex;
        }

        // once the largest element is found
        if (largestIndex != index) {
            // swap the latest large value to the node where it shall be
            int temp = arr.get(largestIndex);
            arr.set(largestIndex, arr.get(index));
            arr.set(index, temp);

            // recursively heapify the bottom nodes
            heapifyDown(largestIndex);
        }
    }

    static void main() {
        // 1. initializeHeap
        arr = new java.util.ArrayList<>();
        count = 0;
        System.out.println("initializeHeap:");

        // 2. insert 4
        arr.add(4);
        count++;
        new ImplementMaxHeap08().heapifyUp(count - 1);
        System.out.println("insert 4:");

        // 3. insert 1
        arr.add(1);
        count++;
        new ImplementMaxHeap08().heapifyUp(count - 1);
        System.out.println("insert 1:");

        // 4. insert 10
        arr.add(10);
        count++;
        new ImplementMaxHeap08().heapifyUp(count - 1);
        System.out.println("insert 10:");

        // 5. getMax
        if (count > 0) {
            System.out.println("getMax: " + arr.get(0)); // 10
        } else {
            System.out.println("getMax: Heap is empty");
        }

        // 6. heapSize
        System.out.println("heapSize: " + count); // 3

        // 7. isEmpty (print 1 if empty, 0 if not empty)
        System.out.println("isEmpty: " + (count == 0 ? 1 : 0)); // 0

        // 8. extractMax
        if (count > 0) {
            arr.set(0, arr.get(count - 1));
            arr.remove(count - 1);
            count--;
            new ImplementMaxHeap08().heapifyDown(0);
        }
        System.out.println("extractMax:");

        // 9. changeKey at index 0 to 16
        if (count > 0) {
            arr.set(0, 16);
            new ImplementMaxHeap08().heapifyUp(0);
            new ImplementMaxHeap08().heapifyDown(0);
        }
        System.out.println("changeKey idx=0 to 16:");

        // 10. getMax
        if (count > 0) {
            System.out.println("getMax: " + arr.get(0)); // 16
        } else {
            System.out.println("getMax: Heap is empty");
        }
    }
}
