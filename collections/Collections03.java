package collections;

import java.util.*;

public class Collections03 {
    public static void main(String[] args) {
        // --- Primitive vs Wrapper Class Comparison ---
        System.out.println("=== Primitive vs Wrapper Class Comparison ===");
        
        // Primitive int comparison
        int a = 2;
        int b = 2;
        System.out.println("Primitive int comparison (a == b): " + (a == b)); // true (value comparison)

        // Wrapper Integer comparison
        Integer a1 = 2;
        Integer b1 = 2;
        System.out.println("Wrapper Integer comparison (a1 == b1): " + (a1 == b1)); // true (cached values -128 to 127)
        
        // Wrapper Integer comparison outside cache range
        Integer c1 = 200;
        Integer c2 = 200;
        System.out.println("Wrapper Integer comparison outside cache (c1 == c2): " + (c1 == c2)); // false
        System.out.println("Wrapper Integer comparison outside cache (c1.equals(c2)): " + c1.equals(c2)); // true

        // --- Object Comparison ---
        System.out.println("\n=== Object Comparison ===");
        
        Employee e1 = new Employee(1, "Anirudh");
        Employee e2 = new Employee(1, "Jwala"); // Same ID, different name

        System.out.println("Employee reference comparison (e1 == e2): " + (e1 == e2)); // false (different objects)
        System.out.println("Employee equals comparison (e1.equals(e2)): " + e1.equals(e2)); // true (same ID)

        // --- HashSet Behavior with Custom Objects ---
        System.out.println("\n=== HashSet Behavior with Custom Objects ===");
        
        HashSet<Employee> employeeSet = new HashSet<>();
        
        // Add same object twice
        employeeSet.add(e1);
        employeeSet.add(e1); // Duplicate reference - only one will be stored
        System.out.println("HashSet with duplicate references: " + employeeSet);

        // Add different objects with same ID
        Employee e3 = new Employee(2, "Anirudh");
        Employee e4 = new Employee(3, "Jwala");
        
        employeeSet = new HashSet<>();
        employeeSet.add(e3);
        employeeSet.add(e4);
        System.out.println("HashSet with different objects: " + employeeSet);

        // --- Array Sorting ---
        System.out.println("\n=== Array Sorting ===");
        
        int[] numbers = {23, 42, 45, 12, 10};
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // Sort primitive array using Arrays.sort() - uses QuickSort
        Arrays.sort(numbers);
        System.out.println("Sorted array (QuickSort): " + Arrays.toString(numbers));

        // Collections.sort() doesn't work with primitive arrays
        // Collections.sort(numbers); // This would cause compilation error

        // --- ArrayList Sorting ---
        System.out.println("\n=== ArrayList Sorting ===");
        
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(23);
        numberList.add(45);
        numberList.add(10);
        numberList.add(12);
        numberList.add(42);
        
        System.out.println("Original ArrayList: " + numberList);

        // Sort ArrayList using Collections.sort() - uses MergeSort
        Collections.sort(numberList);
        System.out.println("Sorted ArrayList (MergeSort): " + numberList);

        // Reverse sort
        Collections.sort(numberList, Collections.reverseOrder());
        System.out.println("Reverse sorted ArrayList: " + numberList);

        // --- Collections Utility Methods ---
        System.out.println("\n=== Collections Utility Methods ===");
        
        System.out.println("Minimum value: " + Collections.min(numberList));
        System.out.println("Maximum value: " + Collections.max(numberList));

        // Fill all elements with same value
        Collections.fill(numberList, 0);
        System.out.println("ArrayList after fill with 0: " + numberList);

        // --- Custom Object Sorting with Comparable ---
        System.out.println("\n=== Custom Object Sorting with Comparable ===");
        
        Employee01 emp1 = new Employee01(100, "Anirudh");
        Employee01 emp2 = new Employee01(101, "Jwala");
        Employee01 emp3 = new Employee01(99, "Alice");
        Employee01 emp4 = new Employee01(102, "Bob");

        ArrayList<Employee01> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        System.out.println("Before sorting: " + employees);

        // Sort using Comparable interface (compareTo method)
        Collections.sort(employees); // Sorts by ID in descending order (as defined in compareTo)
        System.out.println("After sorting by Comparable (ID desc): " + employees);

        // --- Custom Object Sorting with Comparator ---
        System.out.println("\n=== Custom Object Sorting with Comparator ===");
        
        // Sort by ID using custom Comparator (ascending order)
        Collections.sort(employees, new IdComparision());
        System.out.println("Sorted by ID (ascending): " + employees);

        // Sort by Name using custom Comparator (alphabetical order)
        Collections.sort(employees, new NameComparision());
        System.out.println("Sorted by Name (alphabetical): " + employees);

        // --- Summary of Sorting Approaches ---
        System.out.println("\n=== Summary of Sorting Approaches ===");
        System.out.println("1. Arrays.sort(array) - QuickSort for primitive arrays");
        System.out.println("2. Collections.sort(list) - MergeSort for Collections");
        System.out.println("3. Comparable - Natural ordering (compareTo method)");
        System.out.println("4. Comparator - Custom ordering (compare method)");
        System.out.println("5. Collections.reverseOrder() - Reverse natural ordering");
    }
}
