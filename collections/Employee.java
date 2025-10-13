package collections;

/**
 * Employee class demonstrating proper equals() and hashCode() implementation
 * for use in Hash-based collections like HashSet and HashMap.
 * 
 * Key Points:
 * - Two employees are considered equal if they have the same ID
 * - hashCode() returns the ID for consistent hashing
 * - toString() provides readable string representation
 */
public class Employee {
    public int id;
    public String name;

    /**
     * Constructor to create an Employee object
     * @param id Employee ID
     * @param name Employee name
     */
    public Employee(int id, String name) {
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
        
        // Cast to Employee type
        Employee other = (Employee) obj;
        
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
     * Provides a readable string representation of the Employee object
     * @return String representation of the employee
     */
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
