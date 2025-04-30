package linked_list.theory;

public class Introduction {
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

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8};
        Node y = new Node(arr[3]);
        System.out.println(y.data);
    }
}
