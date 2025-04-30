package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 * <p>
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern11 {
    void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            boolean value = i % 2 != 0;

            for (int j = 0; j < i; j++) {
                System.out.print((value ? 1 : 0) + " ");
                value = !value;
            }

            System.out.println();
        }
    }
}
