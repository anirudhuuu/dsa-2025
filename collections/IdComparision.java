package collections;

import java.util.Comparator;

/**
 * IdComparision class implementing Comparator interface
 * This class provides a custom comparison strategy for sorting Employee01 objects by ID
 * in ascending order (lowest ID first).
 * 
 * Key Points:
 * - Implements Comparator<Employee01> for custom sorting
 * - compare() method defines the comparison logic
 * - Sorts by ID in ascending order (o1.id - o2.id)
 * - Can be used with Collections.sort(list, comparator)
 * 
 * Usage:
 * Collections.sort(employees, new IdComparision());
 */
public class IdComparision implements Comparator<Employee01> {

    /**
     * Override compare() method from Comparator interface
     * Compares two Employee01 objects based on their ID field
     * 
     * Comparison logic:
     * - Returns negative value if o1.id < o2.id (o1 comes before o2)
     * - Returns positive value if o1.id > o2.id (o1 comes after o2)
     * - Returns 0 if o1.id == o2.id (equal)
     * 
     * This results in ascending order sorting (lowest ID first)
     * 
     * @param o1 First Employee01 object to compare
     * @param o2 Second Employee01 object to compare
     * @return negative, zero, or positive integer based on comparison
     */
    @Override
    public int compare(Employee01 o1, Employee01 o2) {
        // Sort by ID in ascending order (lowest ID first)
        return o1.id - o2.id;
        
        // Alternative: Sort by ID in descending order (highest ID first)
        // return o2.id - o1.id;
    }
}
