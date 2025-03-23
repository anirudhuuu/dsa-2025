package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given
 * below for any value of N. Let's say for N = 5,
 * the pattern should look like as below:
 * <p>
 * ***** <p>
 * ***** <p>
 * ***** <p>
 * ***** <p>
 * ***** <p>
 */
public class Pattern01 {
    void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
                // System.out.print("(" + i + "," + j + ")");
            }
            System.out.println();
        }
    }
}
