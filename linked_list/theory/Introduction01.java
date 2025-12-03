package linked_list.theory;

/*
 * Intro to Linked List
 * =======================
 * Represent the atomic node of linked list at memory
 */
public class Introduction01 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void main() {
        int[] arr = {2, 5, 6, 8};

        Node y = new Node(arr[3]);
        System.out.println(y.data);
    }
}
