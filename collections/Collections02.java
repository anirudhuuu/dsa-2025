package collections;

import java.util.*;

public class Collections02 {
    public static void main(String[] args) {
        // --- Stack Demo ---
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(1); // [1]
        stack.push(20); // [1, 20]
        stack.push(30); // [1, 20, 30]

        System.out.println("Stack: " + stack);

        // Peek (view top element without removing)
        System.out.println("Peek: " + stack.peek());

        // Pop (remove and return top element)
        int popped = stack.pop(); // Remove 30
        System.out.println("Popped: " + popped);
        System.out.println("Stack after pop: " + stack);

        // Check if empty and size
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());

        // --- Queue Demo ---
        Queue<Integer> queue = new LinkedList<>();

        // Add elements
        queue.offer(20); // [20]
        queue.offer(30); // [20, 30]
        queue.offer(40); // [20, 30, 40]

        System.out.println("Queue: " + queue);

        // Peek (view front element without removing)
        System.out.println("Peek: " + queue.peek());

        // Poll (remove and return front element)
        int polled = queue.poll(); // Remove 20
        System.out.println("Polled: " + polled);
        System.out.println("Queue after poll: " + queue);

        // --- PriorityQueue Demo ---
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> priorityQueueDesc = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to min-heap
        priorityQueue.offer(10); // [10]
        priorityQueue.offer(40); // [10, 40]
        priorityQueue.offer(30); // [10, 30, 40]
        priorityQueue.offer(5); // [5, 10, 30, 40]
        priorityQueue.offer(50); // [5, 10, 30, 40, 50]

        System.out.println("PriorityQueue (min-heap): " + priorityQueue);

        // Poll removes minimum element
        int min = priorityQueue.poll(); // Remove 5
        System.out.println("Polled minimum: " + min);
        System.out.println("PriorityQueue after poll: " + priorityQueue);

        // Add elements to max-heap
        priorityQueueDesc.offer(10);
        priorityQueueDesc.offer(40);
        priorityQueueDesc.offer(30);
        priorityQueueDesc.offer(5);
        priorityQueueDesc.offer(50);

        System.out.println("PriorityQueue (max-heap): " + priorityQueueDesc);
        System.out.println("Polled maximum: " + priorityQueueDesc.poll());

        // --- ArrayDeque Demo ---
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // Add elements at both ends
        arrayDeque.offer(10); // [10]
        arrayDeque.offerFirst(20); // [20, 10]
        arrayDeque.offerLast(30); // [20, 10, 30]
        arrayDeque.offer(40); // [20, 10, 30, 40]
        arrayDeque.offerLast(50); // [20, 10, 30, 40, 50]
        arrayDeque.offer(60); // [20, 10, 30, 40, 50, 60]

        System.out.println("ArrayDeque: " + arrayDeque);

        // Peek operations
        System.out.println("Peek first: " + arrayDeque.peek());
        System.out.println("Peek last: " + arrayDeque.peekLast());

        // Poll operations
        System.out.println("Poll first: " + arrayDeque.poll());
        System.out.println("Poll last: " + arrayDeque.pollLast());
        System.out.println("Poll first again: " + arrayDeque.pollFirst());
        System.out.println("ArrayDeque after operations: " + arrayDeque);

        // --- HashSet Demo ---
        Set<Integer> hashSet = new HashSet<>();

        // Add elements (duplicates are ignored)
        hashSet.add(10); // [10]
        hashSet.add(20); // [10, 20]
        hashSet.add(30); // [10, 20, 30]
        hashSet.add(10); // [10, 20, 30] (duplicate ignored)
        hashSet.add(50); // [10, 20, 30, 50]
        hashSet.add(20); // [10, 20, 30, 50] (duplicate ignored)

        System.out.println("HashSet: " + hashSet);

        // Check contains and size
        System.out.println("Contains 30? " + hashSet.contains(30));
        System.out.println("HashSet size: " + hashSet.size());

        // Remove element
        hashSet.remove(20);
        System.out.println("HashSet after removing 20: " + hashSet);

        // --- LinkedHashSet Demo ---
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        // Add elements (maintains insertion order)
        linkedHashSet.add(10); // [10]
        linkedHashSet.add(20); // [10, 20]
        linkedHashSet.add(30); // [10, 20, 30]
        linkedHashSet.add(10); // [10, 20, 30] (duplicate ignored)
        linkedHashSet.add(5); // [10, 20, 30, 5]
        linkedHashSet.add(20); // [10, 20, 30, 5] (duplicate ignored)

        System.out.println("LinkedHashSet (maintains order): " + linkedHashSet);

        // --- TreeSet Demo ---
        Set<Integer> treeSet = new TreeSet<>();

        // Add elements (automatically sorted)
        treeSet.add(10); // [10]
        treeSet.add(20); // [10, 20]
        treeSet.add(30); // [10, 20, 30]
        treeSet.add(10); // [10, 20, 30] (duplicate ignored)
        treeSet.add(5); // [5, 10, 20, 30]
        treeSet.add(20); // [5, 10, 20, 30] (duplicate ignored)

        System.out.println("TreeSet (sorted order): " + treeSet);

        // --- HashMap Demo ---
        Map<Integer, String> hashMap = new HashMap<>();

        // Add key-value pairs
        hashMap.put(1, "Prateek"); // {1=Prateek}
        hashMap.put(2, "Gopal"); // {1=Prateek, 2=Gopal}
        hashMap.put(3, "Nagaraj"); // {1=Prateek, 2=Gopal, 3=Nagaraj}
        hashMap.put(4, "Rajak"); // {1=Prateek, 2=Gopal, 3=Nagaraj, 4=Rajak}

        // Check before adding duplicate key
        if (!hashMap.containsKey(4)) {
            hashMap.put(4, "Projit");
        }

        // Add more entries
        hashMap.put(5, "Gopal"); // {1=Prateek, 2=Gopal, 3=Nagaraj, 4=Rajak, 5=Gopal}
        hashMap.putIfAbsent(5, "Saumya"); // Won't add since key 5 exists

        System.out.println("HashMap: " + hashMap);

        // Iterate through keys
        System.out.print("Keys: ");
        for (Integer key : hashMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Iterate through values
        System.out.print("Values: ");
        for (String value : hashMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Iterate through entries
        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Check contains and size
        System.out.println("Contains key 3? " + hashMap.containsKey(3));
        System.out.println("Contains value 'Gopal'? " + hashMap.containsValue("Gopal"));
        System.out.println("HashMap size: " + hashMap.size());

        // --- LinkedHashMap Demo ---
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // Add elements (maintains insertion order)
        linkedHashMap.put(1, "Prateek"); // {1=Prateek}
        linkedHashMap.put(2, "Gopal"); // {1=Prateek, 2=Gopal}
        linkedHashMap.put(3, "Nagaraj"); // {1=Prateek, 2=Gopal, 3=Nagaraj}
        linkedHashMap.put(4, "Rajak"); // {1=Prateek, 2=Gopal, 3=Nagaraj, 4=Rajak}

        System.out.println("LinkedHashMap (maintains order): " + linkedHashMap);

        // --- TreeMap Demo ---
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Add elements (automatically sorted by key)
        treeMap.put(3, "Nagaraj"); // {3=Nagaraj}
        treeMap.put(1, "Prateek"); // {1=Prateek, 3=Nagaraj}
        treeMap.put(4, "Rajak"); // {1=Prateek, 3=Nagaraj, 4=Rajak}
        treeMap.put(2, "Gopal"); // {1=Prateek, 2=Gopal, 3=Nagaraj, 4=Rajak}

        System.out.println("TreeMap (sorted by key): " + treeMap);

        // Get first and last entries
        System.out.println("First entry: " + treeMap.firstEntry());
        System.out.println("Last entry: " + treeMap.lastEntry());
    }
}
