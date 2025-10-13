package collections;

/**
 * Employee01 class implementing Comparable interface for natural ordering
 * This class demonstrates how to make objects sortable using Collections.sort()
 * without providing a custom Comparator.
 * 
 * Key Points:
 * - Implements Comparable<Employee01> for natural ordering
 * - compareTo() method defines the default sorting criteria
 * - Currently sorts by ID in descending order (highest ID first)
 * - Can be used with Collections.sort(list) directly
 */
public class Employee01 implements Comparable<Employee01> {
    public int id;
    public String name;

    /**
     * Constructor to create an Employee01 object
     * @param id Employee ID
     * @param name Employee name
     */
    public Employee01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Override hashCode() method
     * Returns the employee ID as the hash code
     * This ensures that employees with the same ID have the same hash code
     * @return hash code based on employee ID
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Override equals() method
     * Two employees are considered equal if:
     * 1. They are the same object reference (this == obj)
     * 2. They have the same ID
     * 3. They have the same name (handles null cases)
     * 
     * @param obj Object to compare with
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Same object reference
        if (this == obj)
            return true;
        
        // Null check
        if (obj == null)
            return false;
        
        // Class type check
        if (getClass() != obj.getClass())
            return false;
        
        // Cast to Employee01 type
        Employee01 other = (Employee01) obj;
        
        // Compare ID
        if (id != other.id)
            return false;
        
        // Compare name (handles null cases)
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        
        return true;
    }

    /**
     * Override toString() method
     * Provides a readable string representation of the Employee01 object
     * @return String representation of the employee
     */
    @Override
    public String toString() {
        return "Employee01 [id=" + id + ", name=" + name + "]";
    }

    /**
     * Override compareTo() method from Comparable interface
     * Defines the natural ordering for Employee01 objects
     * 
     * Current implementation sorts by ID in descending order:
     * - Returns positive value if this.id < other.id (this comes after other)
     * - Returns negative value if this.id > other.id (this comes before other)
     * - Returns 0 if this.id == other.id (equal)
     * 
     * To sort in ascending order, use: return this.id - o.id;
     * 
     * @param o Employee01 object to compare with
     * @return negative, zero, or positive integer based on comparison
     */
    @Override
    public int compareTo(Employee01 o) {
        // Sort by ID in descending order (highest ID first)
        return o.id - this.id;
        
        // Alternative: Sort by ID in ascending order (lowest ID first)
        // return this.id - o.id;
    }
}
