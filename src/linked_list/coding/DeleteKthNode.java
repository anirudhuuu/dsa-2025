package linked_list.coding;

public class DeleteKthNode {
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

    ListNode deleteKthNode(ListNode head, int k) {
        // Empty list is passed
        if (head == null) {
            return null;
        }

        // First value of the list is expected to remove
        if (k == 1) {
            head = head.next;
            return head;
        }

        int count = 0;
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            count += 1;

            if (count == k) {
                prev.next = temp.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}
