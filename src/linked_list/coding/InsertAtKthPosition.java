package linked_list.coding;

/**
 * Given the head of a singly linked list and two integers X and K,
 * insert a node with value X as the kth node of the linked list
 * and return the head of the modified list.
 */
public class InsertAtKthPosition {
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

    ListNode insertAtKthPosition(ListNode head, int X, int K) {
        // List is empty
        if (head == null) {
            if (K == 1) {
                ListNode newNode = new ListNode(X);
                head = newNode;
                return head;
            }

            return null;
        }

        // Element to be added at index 1
        if (K == 1) {
            ListNode newNode = new ListNode(X, head);
            return newNode;
        }

        // More are present in the list
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count += 1;

            if (count == K - 1) {
                ListNode newNode = new ListNode(X);
                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }
}
