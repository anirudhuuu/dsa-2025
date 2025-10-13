package collections;

import java.util.Comparator;

/**
 * NameComparision class implementing Comparator interface
 * This class provides a custom comparison strategy for sorting Employee01 objects by name
 * in alphabetical order (A to Z).
 * 
 * Key Points:
 * - Implements Comparator<Employee01> for custom sorting
 * - compare() method defines the comparison logic
 * - Sorts by name in alphabetical order using String.compareTo()
 * - Can be used with Collections.sort(list, comparator)
 * 
 * Usage:
 * Collections.sort(employees, new NameComparision());
 */
public class NameComparision implements Comparator<Employee01> {

    /**
     * Override compare() method from Comparator interface
     * Compares two Employee01 objects based on their name field
     * 
     * Comparison logic:
     * - Uses String.compareTo() for lexicographical comparison
     * - Returns negative value if o1.name comes before o2.name alphabetically
     * - Returns positive value if o1.name comes after o2.name alphabetically
     * - Returns 0 if o1.name equals o2.name
     * 
     * This results in alphabetical order sorting (A to Z)
     * 
     * Note: String.compareTo() is case-sensitive. For case-insensitive sorting,
     * use: o1.name.compareToIgnoreCase(o2.name)
     * 
     * @param o1 First Employee01 object to compare
     * @param o2 Second Employee01 object to compare
     * @return negative, zero, or positive integer based on comparison
     */
    @Override
    public int compare(Employee01 o1, Employee01 o2) {
        // Sort by name in alphabetical order (A to Z)
        return o1.name.compareTo(o2.name);
        
        // Alternative: Case-insensitive alphabetical sorting
        // return o1.name.compareToIgnoreCase(o2.name);
        
        // Alternative: Reverse alphabetical order (Z to A)
        // return o2.name.compareTo(o1.name);
    }
}
