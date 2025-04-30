package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given
 * below for any value of N. Let's say for N = 5, the pattern
 * should look like as below:
 * <p>
 * E
 * D E
 * C D E
 * B C D E
 * A B C D E
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern18 {
    void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                char ch = 'A';
                ch = (char) (ch + n - i + j - 1);
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
