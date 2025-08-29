package implementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queue
 * ==============================
 * Implement a Last-In-First-Out (LIFO) stack using a single queue. The
 * implemented stack should support the following operations: push, pop, top,
 * and isEmpty.
 * 
 * Implement the QueueStack class:
 * - void push(int x): Pushes element x onto the stack.
 * - int pop(): Removes and returns the top element of the stack.
 * - int top(): Returns the top element of the stack without removing it.
 * - boolean isEmpty(): Returns true if the stack is empty, false otherwise.
 */
public class StackUsingQueue05 {
    private Queue<Integer> queue;

    public StackUsingQueue05() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);

        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue05 stack = new StackUsingQueue05();
        stack.push(4);
        stack.push(8);
        System.out.println(stack.pop()); // returns 8
        System.out.println(stack.top()); // returns 4
        System.out.println(stack.isEmpty()); // returns false
    }
}
