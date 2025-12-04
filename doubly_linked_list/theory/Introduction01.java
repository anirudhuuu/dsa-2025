package doubly_linked_list.theory;

/*
 * Intro to Doubly Linked List
 * =======================
 * Represent the atomic node of doubly linked list at memory
 */
public class Introduction01 {
    class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        Node(int data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
}
