package linked_list.theory;

/*
 * Array to Linked List
 * =======================
 * Goal is to convert the given array input into a Linked list at memory level
 *
 * Time Complexity: O(N)
 */
class ArrayToLL02 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node convertArrayToLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node mover = head;

        // First element is added, start from next value
        for (int i = 1; i < arr.length; i++) {
            // Create a temporary node
            Node temp = new Node(arr[i]);

            // Update the mover with temp's location
            mover.next = temp;

            // Update the move to move-forward on the newly added value
            mover = temp;
        }

        return head;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static void main() {
        int[] arr = {12, 5, 8, 7, 23, 96, 120, 532};
        Node head = new ArrayToLL02().convertArrayToLinkedList(arr);
        System.out.println("Head of the linked list :: " + head.data);
        System.out.println("Linked list after converting from array:");
        new ArrayToLL02().printList(head);
    }
}
