package linked_list.coding;

/**
 * Given the head of a singly linked list and an
 * integer X, delete the node with value X and
 * return the head of the modified list.
 */
public class DeleteNodeWithValueX {
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

    ListNode deleteNodeWithValueX(ListNode head, int X) {
        // Empty list is passed
        if (head == null) {
            return null;
        }

        // First value of the list is expected to remove
        if (X == head.val) {
            head = head.next;
            return head;
        }

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == X) {
                prev.next = temp.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}
