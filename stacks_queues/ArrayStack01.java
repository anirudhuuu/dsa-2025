package stacks_queues;

/**
 * Implement Stack using Arrays
 * =============================
 * Implement a Last-In-First-Out (LIFO) stack using an array. The implemented
 * stack should support the following operations: push, pop, peek, and isEmpty.
 * 
 * Implement the ArrayStack class:
 * - void push(int x): Pushes element x onto the stack.
 * - int pop(): Removes and returns the top element of the stack.
 * - int top(): Returns the top element of the stack without removing it.
 * - boolean isEmpty(): Returns true if the stack is empty, false otherwise.
 */
public class ArrayStack01 {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack01() {
        this(1000);
    }

    public ArrayStack01(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top >= capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }

        top = top + 1;
        stack[top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stack[top--];
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack01 stack = new ArrayStack01(5);
        // Operations on a stack
        stack.push(10);
        stack.push(20);
        System.out.println("Top element :: " + stack.top());
        System.out.println("Popped element :: " + stack.pop());
        System.out.println("Top element :: " + stack.top());
        System.out.println("Is stack empty? :: " + stack.isEmpty());
    }
}
