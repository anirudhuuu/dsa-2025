package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 * <p>
 * 1        1
 * 12      21
 * 123    321
 * 1234  4321
 * 1234554321
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern12 {
    void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            // Numbers
            for (int j = 1; j < i + 1; j++) {
                System.out.print(j);
            }

            // Spaces
            for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }

            // Spaces
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }

            // Numbers
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
