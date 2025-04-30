package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 * <p>
 * 12345 <p>
 * 1234  <p>
 * 123   <p>
 * 12    <p>
 * 1     <p>
 */
public class Pattern06 {
    void pattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(n - j + 1);
            }
            System.out.println();
        }
    }
}
