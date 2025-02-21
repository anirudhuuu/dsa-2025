package linked_list;

public class ArrayToLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            // Take the value from array and create a node
            Node temp = new Node(arr[i]);

            // Current's next location must point to the newly created value
            current.next = temp;

            // Current must proceed forward and
            // new Current will be nothing but temp
            current = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convertArrayToLinkedList(arr);
        System.out.println(head.data);
    }
}
