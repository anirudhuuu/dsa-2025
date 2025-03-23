package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below for
 * any value of N. Let's say for N = 5, the pattern
 * should look like as below:
 * <p>
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern13 {
    void pattern13(int n) {
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(counter + " ");
                counter += 1;
            }
            System.out.println();
        }
    }
}
