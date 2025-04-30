package linked_list.coding;

/**
 * Given the head of a singly linked list and two integers X and val,
 * insert a node with value val before the node with value X in
 * the linked list and return the head of the modified list.
 */
public class InsertBeforeX {
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

    ListNode insertBeforeX(ListNode head, int X, int val) {
        // List is empty
        if (head == null) {
            return null;
        }

        // Element to be added at index 1
        if (head.val == X) {
            ListNode newNode = new ListNode(val, head);
            return newNode;
        }

        // More are present in the list
        ListNode temp = head;

        while (temp.next != null) {
            if (temp.next.val == X) {
                ListNode newNode = new ListNode(val);
                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }
}
