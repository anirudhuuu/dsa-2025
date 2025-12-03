package linked_list.theory;

/*
 * Deletion in Linked list
 * ==========================
 * Goal is to perform the operation of delete at following ways:
 * - head
 * - tail
 * - position
 * - value
 */
public class DeletionLL04 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node deleteAtHead(Node head) {
        // Check for empty list
        if (head == null) {
            return null;
        }

        head = head.next;

        // Send back the new head
        return head;
    }

    Node deleteTail(Node head) {
        // Check for empty list
        if (head == null) {
            return null;
        }

        // Check if list has only single element
        if (head.next == null) {
            return null;
        }

        Node temp = head;
        // Traverse until last but-one element
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // last but-one element must lose reference to the last element
        // and become the new last element
        temp.next = null;

        return head;
    }

    // Remove value at K-th index wrt (1-based indexing)
    Node deleteKthValue(Node head, int k) {
        // List is empty
        if (head == null) {
            return null;
        }

        // Trying to delete the first element
        if (k == 1) {
            head = head.next;
            return head;
        }

        int count = 0;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            count += 1;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    // Find and delete a value
    Node deleteByValue(Node head, int value) {
        // List is empty
        if (head == null) {
            return null;
        }

        // Trying to delete the first element
        if (head.data == value) {
            head = head.next;
            return head;
        }

        Node prev = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    void main() {
        Node head = new Node(10);
        head.next = new Node(20, null);
        head.next.next = new Node(30, null);
        head.next.next.next = new Node(40, null);
        head.next.next.next.next = new Node(50, null);
        head.next.next.next.next.next = new Node(60, null);
        head.next.next.next.next.next.next = new Node(70, null);
        head.next.next.next.next.next.next.next = new Node(80, null);

        deleteAtHead(head);
        deleteTail(head);
        deleteKthValue(head, 2);
        deleteByValue(head, 50);
    }
}
