package doubly_linked_list.theory;

import linked_list.theory.DeletionLL04;

/*
 * Deletion in Doubly Linked list
 * ==========================
 * Goal is to perform the operation of delete at following ways:
 * - head
 * - tail
 * - k-th position
 * - node
 */
public class DeletionDLL02 {
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

    Node deleteAtHead(Node head) {
        // empty list
        if (head == null) {
            return null;
        }

        // only one element is present
        if (head.next == null) {
            return null;
        }

        // more than 1 one element present
        Node prev = head;
        head = head.next;
        head.previous = null;
        prev.next = null;

        return head;
    }

    Node deleteTail(Node head) {
        // empty list
        if (head == null) {
            return null;
        }

        // only one element is present
        if (head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newTail = temp.previous;
        newTail.next = null;
        temp.previous = null;

        return head;
    }

    // Remove value at K-th index wrt (1-based indexing)
    Node deleteKthValue(Node head, int k) {
        // empty list
        if (head == null) {
            return null;
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            count += 1;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.previous;
        Node front = temp.next;

        // only 1 element in the list
        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            // first element of the list
            return deleteAtHead(head);
        } else if (front == null) {
            return deleteTail(head);
        } else {
            // somewhere in between we have a node at k-th position to remove
            prev.next = front;
            front.previous = prev;

            temp.next = null;
            temp.previous = null;
        }

        return head;
    }

    // Delete the given node
    Node deleteByNode(Node head, Node nodeToDelete) {
        // condition: it will never be the head
        Node prev = nodeToDelete.previous;
        Node front = nodeToDelete.next;

        // if the node to delete is "tail", then
        if (front == null) {
            prev.next = null;
            nodeToDelete.previous = null;
            return head;
        }

        prev.next = front;
        front.previous = prev;

        nodeToDelete.previous = null;
        nodeToDelete.next = null;

        return head;
    }

    static void main() {
        Node head = new Node(10);
        Node n2 = new Node(20, null, head);
        head.next = n2;

        Node n3 = new Node(30, null, n2);
        n2.next = n3;

        Node n4 = new Node(40, null, n3);
        n3.next = n4;

        Node n5 = new Node(50, null, n4);
        n4.next = n5;

        Node n6 = new Node(60, null, n5);
        n5.next = n6;

        DeletionDLL02 dll = new DeletionDLL02();

        head = dll.deleteAtHead(head);

        head = dll.deleteTail(head);

        head = dll.deleteKthValue(head, 3);

        head = dll.deleteByNode(head, n3);
    }
}
