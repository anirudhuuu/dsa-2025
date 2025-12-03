package linked_list.theory;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse a linked list
 * ========================
 * Goal is to traverse the entire linked list and print output
 */
public class TraverseLL03 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public List<Integer> traverseLL(Node head) {
        List<Integer> list = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list;
    }

    static void main() {
        int[] arr = {12, 5, 8, 7};
        Node head = new TraverseLL03().convertArrayToLinkedList(arr);

        List<Integer> result = new TraverseLL03().traverseLL(head);
        for (Integer val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
