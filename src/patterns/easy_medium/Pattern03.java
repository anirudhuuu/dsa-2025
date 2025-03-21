package patterns.easy_medium;

/**
 * Given an integer n. You need to recreate the pattern given below
 * for any value of N. Let's say for N = 5, the pattern
 * should look like as below:
 * <p>
 * 1     <p>
 * 12    <p>
 * 123   <p>
 * 1234  <p>
 * 12345 <p>
 */
public class Pattern03 {
    void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}
