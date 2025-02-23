package linked_list.coding;

/**
 * Given the head of a singly linked list, delete the head of the
 * linked list and return the head of the modified list.
 * <p>
 * The head is the first node of the linked list.
 */
public class DeleteHead {
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

    ListNode deleteHead(ListNode head) {
        // Empty list is passed
        if (head == null) {
            // Nothing is left to remove
            return null;
        }

        // One value list is passed
        if (head.next == null) {
            // Remove the one single element present
            head = null;
            return head;
        }

        // More than one value is present in list
        // Move current head one-step forward
        head = head.next;
        return head;
    }
}
