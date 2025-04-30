package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below
 * for any value of N. Let's say for N = 5, the pattern should look
 * like as below:
 * <p>
 * A
 * BB
 * CCC
 * DDDD
 * EEEEE
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern16 {
    void pattern16(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                char alphabet = (char) ('A' + i);
                System.out.print(alphabet);
            }
            System.out.println();
        }
    }
}
