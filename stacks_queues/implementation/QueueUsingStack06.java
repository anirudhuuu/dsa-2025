package implementation;

import java.util.Stack;

/**
 * Implement Queue using Stack
 * ==============================
 * Implement a First-In-First-Out (FIFO) queue using two stacks. The implemented
 * queue should support the following operations: push, pop, peek, and isEmpty.
 * 
 * Implement the StackQueue class:
 * - void push(int x): Adds element x to the end of the queue.
 * - int pop(): Removes and returns the front element of the queue.
 * - int peek(): Returns the front element of the queue without removing it.
 * - boolean isEmpty(): Returns true if the queue is empty, false otherwise.
 */
public class QueueUsingStack06 {
    private Stack<Integer> stack01;
    private Stack<Integer> stack02;

    public QueueUsingStack06() {
        stack01 = new Stack<>();
        stack02 = new Stack<>();
    }

    public void push(int x) {
        // Copy all elements of stack01 to stack02
        while (!stack01.isEmpty()) {
            int element = stack01.pop();
            stack02.push(element);
        }

        // Add new element into stack01
        stack01.push(x);

        // Move all elements from stack02 to stack01
        while (!stack02.isEmpty()) {
            int element = stack02.pop();
            stack01.push(element);
        }
    }

    public int pop() {
        return stack01.pop();
    }

    public int peek() {
        return stack01.peek();
    }

    public boolean isEmpty() {
        return stack01.isEmpty() && stack02.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack06 queue = new QueueUsingStack06();
        queue.push(4);
        queue.push(8);
        System.out.println(queue.pop()); // returns 4
        System.out.println(queue.peek()); // returns 8
        System.out.println(queue.isEmpty()); // returns false
    }
}
