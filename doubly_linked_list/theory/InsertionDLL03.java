package doubly_linked_list.theory;

/**
 * Insertion in Doubly linked list
 * ===================================
 * To be able to perform the following operations in the list before:
 * - head
 * - tail
 * - k-th index
 * - given node
 */
public class InsertionDLL03 {
    static class Node {
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

    Node insertBeforeHead(Node head, int value) {
        Node newNode = new Node(value, head, null);
        head.previous = newNode;
        head = newNode;
        return head;
    }

    Node insertBeforeTail(Node head, int value) {
        // only 1 element is present
        if (head.next == null) {
            return insertBeforeHead(head, value);
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node prev = temp.previous;
        Node newNode = new Node(value, temp, prev);

        prev.next = newNode;
        temp.previous = newNode;

        return head;
    }

    Node insertBeforeKthNode(Node head, int value, int k) {
        if (k == 1) {
            return insertBeforeHead(head, value);
        }

        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count += 1;

            if (count == k) {
                break;
            }

            temp = temp.next;
        }

        Node prev = temp.previous;
        Node newNode = new Node(value, temp, prev);
        prev.next = newNode;
        temp.previous = newNode;

        return head;
    }

    void insertBeforeNode(Node node, int val) {
        // condition: it will never be the head
        Node previous = node.previous;
        Node newNode = new Node(val, node, previous);

        previous.next = newNode;
        node.previous = newNode;
    }

    static void main() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.previous = head;
        head.next.next = new Node(30);
        head.next.next.previous = head.next;

        Node node20 = head.next;

        head = new InsertionDLL03().insertBeforeHead(head, 5);
        head = new InsertionDLL03().insertBeforeTail(head, 25);
        head = new InsertionDLL03().insertBeforeKthNode(head, 15, 3);

        new InsertionDLL03().insertBeforeNode(node20, 17);
    }
}
