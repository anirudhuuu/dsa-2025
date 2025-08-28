package stacks_queues;

/**
 * Implement Queue using Arrays
 * ==============================
 * Implement a First-In-First-Out (FIFO) queue using an array. The implemented
 * queue should support the following operations: push, dequeue, pop, and
 * isEmpty.
 * 
 * Implement the ArrayQueue class:
 * - void push(int x): Adds element x to the end of the queue.
 * - int pop(): Removes and returns the front element of the queue.
 * - int peek(): Returns the front element of the queue without removing it.
 * - boolean isEmpty(): Returns true if the queue is empty, false otherwise.
 */
public class ArrayQueue02 {
    private int[] queue;
    private int start, end;
    private int currentSize, maxSize;

    public ArrayQueue02() {
        this(1000);
    }

    public ArrayQueue02(int size) {
        start = -1;
        end = -1;
        currentSize = 0;

        maxSize = size;
        queue = new int[maxSize];
    }

    public void push(int x) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }

        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % maxSize;
        }

        currentSize = currentSize + 1;

        queue[end] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int poppedElement = queue[start];

        if (currentSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % maxSize;
        }

        currentSize = currentSize - 1;

        return poppedElement;
    }

    public int peek() {
        // this is nothing but requesting for "top" element
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[start];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public static void main(String[] args) {
        ArrayQueue02 queue = new ArrayQueue02(5);
        // Operations on a queue
        queue.push(10);
        queue.push(20);
        System.out.println("Front element :: " + queue.peek());
        System.out.println("Popped element :: " + queue.pop());
        System.out.println("Front element :: " + queue.peek());
        System.out.println("Is queue empty? :: " + queue.isEmpty());
    }
}
