package linked_list.theory;

import java.util.ArrayList;
import java.util.List;

public class LLToArray {
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

    static List<Integer> convertLinkedListToArray(Node head) {
        List<Integer> result = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            result.add(temp.data);

            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        List<Integer> result = convertLinkedListToArray(head);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
