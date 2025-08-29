package implementation;

/**
 * Implement stack using Linkedlist
 * =================================
 * Implement a Last-In-First-Out (LIFO) stack using a singly linked list. The
 * implemented stack should support the following operations: push, pop, top,
 * and isEmpty.
 * 
 * Implement the LinkedListStack class:
 * - void push(int x): Pushes element x onto the stack.
 * - int pop(): Removes and returns the top element of the stack.
 * - int top(): Returns the top element of the stack without removing it.
 * - boolean isEmpty(): Returns true if the stack is empty, false otherwise.
 */
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class LinkedListStack03 {
    private Node top;
    private int size;

    public LinkedListStack03() {
        top = null;
        size = 0;
    }

    public void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size = size + 1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int poppedValue = top.data;

        Node temp = top;
        top = top.next;
        temp = null;

        size = size - 1;

        return poppedValue;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack03 stack = new LinkedListStack03();
        // Operations on a stack
        stack.push(10);
        stack.push(20);
        System.out.println("Top element :: " + stack.top());
        System.out.println("Popped element :: " + stack.pop());
        System.out.println("Top element :: " + stack.top());
        System.out.println("Is stack empty? :: " + stack.isEmpty());
    }
}
