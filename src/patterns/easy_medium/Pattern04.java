package patterns.easy_medium;

/**
 * Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
 * <p>
 * 1     <p>
 * 22    <p>
 * 333   <p>
 * 4444  <p>
 * 55555 <p>
 */
public class Pattern04 {
    void pattern4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }
}
