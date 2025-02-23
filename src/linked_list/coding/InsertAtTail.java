package linked_list.coding;

/**
 * Given the head of a singly linked list and an integer X, insert a node with value X
 * at the tail of the linked list and return the head of the modified list.
 * <p>
 * The tail is the last node of the linked list.
 */
public class InsertAtTail {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }

    ListNode insertAtTail(ListNode head, int X) {
        // List is empty
        if (head == null) {
            ListNode newNode = new ListNode(X);
            head = newNode;
            return head;
        }

        // List has values present
        ListNode temp = head;

        // Traverse until you reach the end of list
        while (temp.next != null) {
            temp = temp.next;
        }

        // Create a new node to append at the end
        ListNode newNode = new ListNode(X);
        temp.next = newNode;

        return head;
    }
}
