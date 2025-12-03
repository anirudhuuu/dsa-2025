package linked_list.theory;

public class InsertionLL05 {
    class Node {
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

    Node insertHead(Node head, int value) {
        // Check if list is empty
        if (head == null) {
            Node temp = new Node(value);
            head = temp;
            return head;
        }

        // One or more elements are present
        Node temp = new Node(value);
        temp.next = head;
        head = temp;

        return head;
    }

    Node insertTail(Node head, int value) {
        // Check if list is empty
        if (head == null) {
            return new Node(value);
        }

        // One or more elements are present
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(value);
        temp.next = newNode;

        return head;
    }

    Node insertAtKthValue(Node head, int value, int k) {
        // Check if list is empty
        if (head == null) {
            // Add in first location
            if (k == 1) {
                return new Node(value);
            }

            return null;
        }

        // One or more elements are present
        if (k == 1) {
            Node temp = new Node(value, head);
            return temp;
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count += 1;

            if (count == k - 1) {
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    Node insertAfterValue(Node head, int value, int prevValue) {
        // Check if list is empty
        if (head == null) {
            return null;
        }

        // One or more elements are present
        if (head.data == prevValue) {
            Node temp = new Node(value, head);
            return temp;
        }

        Node temp = head;
        while (temp.next != null) {

            if (temp.next.data == prevValue) {
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }
}
