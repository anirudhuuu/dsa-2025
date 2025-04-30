package linked_list.coding;

/**
 * Given the head of a singly linked list, delete the tail of the
 * linked list and return the head of the modified list.
 * <p>
 * The tail is the last node of the linked list.
 */
public class DeleteTail {
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

    ListNode deleteTail(ListNode head) {
        // Empty list is passed
        if (head == null) {
            // Nothing to delete
            return null;
        }

        // Only single element is present in the list
        if (head.next == null) {
            // head and tail are same values
            head = null;
            return null;
        }

        // More than one value is present in the list
        ListNode temp = head;

        // Traverse until last-but-one location
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // On reaching the last-but-one location
        // make it as new last for the list
        temp.next = null;

        return head;
    }
}
