package patterns.easy_medium;

/**
 * Given an integer n. You need to recreate the pattern given below
 * for any value of N. Let's say for N = 5, the
 * pattern should look like as below:
 * <p>
 * ***** <p>
 * ****  <p>
 * ***   <p>
 * **    <p>
 * *     <p>
 */
public class Pattern05 {
    void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
