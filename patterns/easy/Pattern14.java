package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern
 * given below for any value of N. Let's say for N = 5,
 * the pattern should look like as below:
 * <p>
 * A
 * AB
 * ABC
 * ABCD
 * ABCDE
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern14 {
    void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                char alphabet = (char) ('A' + j);
                System.out.print(alphabet);
            }
            System.out.println();
        }
    }
}
