package linked_list.coding;

/**
 * Given the head of a singly linked list and an integer X, insert
 * a node with value X at the head of the linked list and
 * return the head of the modified list.
 * <p>
 * The head is the first node of the linked list.
 */
public class InsertAtHead {
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

    ListNode insertAtHead(ListNode head, int X) {
        // Create a new node with data
        // next pointing to current head present
        ListNode newNode = new ListNode(X, head);

        // Update overall head to point to new node
        head = newNode;

        return head;
    }
}
