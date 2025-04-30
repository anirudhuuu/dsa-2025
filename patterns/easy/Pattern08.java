package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern
 * given below for any value of N. Let's say for N = 5,
 * the pattern should look like as below:
 * <p>
 * <p>*********</p>
 * <p> ******* </p>
 * <p>  *****  </p>
 * <p>   ***   </p>
 * <p>    *    </p>
 * Print the pattern in the function given to you.
 */
public class Pattern08 {
    void pattern08(int n) {
        for (int i = n - 1; i >= 0; i--) {
            // Spaces
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 0; j < ((2 * i) + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
