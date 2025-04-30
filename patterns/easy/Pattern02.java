package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given
 * below for any value of N.
 * Let's say for N = 5, the pattern should look like as below:
 * <p>
 * *     <p>
 * **    <p>
 * ***   <p>
 * ****  <p>
 * ***** <p>
 */
public class Pattern02 {
    void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
