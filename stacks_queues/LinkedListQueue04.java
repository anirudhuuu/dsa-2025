package stacks_queues;

/**
 * Implement queue using Linkedlist
 * =================================
 * Implement a First-In-First-Out (FIFO) queue using a singly linked list. The
 * implemented queue should support the following operations: push, pop, peek,
 * and isEmpty.
 * 
 * Implement the LinkedListQueue class:
 * - void push(int x): Adds element x to the end of the queue.
 * - int pop(): Removes and returns the front element of the queue.
 * - int peek(): Returns the front element of the queue without removing it.
 * - boolean isEmpty(): Returns true if the queue is empty, false otherwise.
 */
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class LinkedListQueue04 {
    private Node start;
    private Node end;
    private int size;

    public LinkedListQueue04() {
        start = end = null;
        size = 0;
    }

    public void push(int x) {
        Node temp = new Node(x);

        if (start == null) {
            start = end = temp;
        } else {
            end.next = temp;
            end = temp;
        }

        size = size + 1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        Node temp = start;
        start = start.next;

        int poppedValue = temp.data;
        temp = null;
        size = size - 1;

        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return start.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
}
