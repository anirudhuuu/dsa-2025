package collections;

import java.util.*;

public class Collections01 {
    public static void main(String[] args) {
        // --- ArrayList Demo ---
        ArrayList<Integer> arr = new ArrayList<>();

        // Add elements
        arr.add(1); // [1]
        arr.add(2); // [1, 2]
        arr.add(3); // [1, 2, 3]
        arr.add(1, 10); // Insert at index 1: [1, 10, 2, 3]

        // Add all from another collection
        List<Integer> extra = Arrays.asList(20, 30);
        arr.addAll(extra); // [1, 10, 2, 3, 20, 30]

        // Remove element by index and by value
        arr.remove(2); // Remove element at index 2: [1, 10, 3, 20, 30]
        arr.remove(Integer.valueOf(20)); // Remove first occurrence of value 20: [1, 10, 3, 30]

        // Update element
        arr.set(1, 99); // Set index 1 to 99: [1, 99, 3, 30]

        // Access elements
        int first = arr.get(0); // 1

        // Iterate with for-each
        System.out.print("ArrayList items:");
        for (int x : arr) {
            System.out.print(" " + x);
        }
        System.out.println();

        // Contains and indexOf
        System.out.println("ArrayList contains 99? " + arr.contains(99));
        System.out.println("Index of 30: " + arr.indexOf(30));
        System.out.println("Is ArrayList empty? " + arr.isEmpty());
        System.out.println("ArrayList size: " + arr.size());

        // --- LinkedList Demo (only new/different things from ArrayList) ---
        LinkedList<String> linked = new LinkedList<>();

        // Add elements at both ends
        linked.add("A"); // [A]
        linked.addLast("B"); // [A, B]
        linked.addFirst("Z"); // [Z, A, B]

        // Peek first/last (does not remove)
        System.out.println("First element: " + linked.peekFirst());
        System.out.println("Last element: " + linked.peekLast());

        // Remove first/last element
        linked.removeFirst(); // [A, B]
        linked.removeLast(); // [A]

        // Add at index
        linked.add(0, "X"); // [X, A]

        // Iterate with iterator
        System.out.print("LinkedList items:");
        Iterator<String> it = linked.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next());
        }
        System.out.println();

        // Poll (retrieve and remove) from front and back
        linked.addLast("Y"); // [X, A, Y]
        System.out.println("Poll first: " + linked.pollFirst()); // X, now [A, Y]
        System.out.println("Poll last: " + linked.pollLast()); // Y, now [A]

        // Stack and Queue methods supported
        linked.push("Head"); // [Head, A]
        String popped = linked.pop(); // Remove "Head"
        System.out.println("Popped from front: " + popped);

        // Size and clear
        System.out.println("LinkedList size: " + linked.size());
        linked.clear();
        System.out.println("LinkedList is empty? " + linked.isEmpty());
    }
}
