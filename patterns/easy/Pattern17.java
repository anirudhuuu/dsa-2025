package patterns.easy;

/**
 * Given an integer n. You need to recreate the pattern given below
 * for any value of N. Let's say for N = 5, the pattern should
 * look like as below:
 * <p>
 * <p>    A    </p>
 * <p>   ABA   </p>
 * <p>  ABCBA  </p>
 * <p> ABCDCBA </p>
 * <p>ABCDEDCBA</p>
 * <p>
 * Print the pattern in the function given to you.
 */
public class Pattern17 {
    void pattern17(int n) {
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }

            // Characters
            char value = 'A';
            int breakpoint = (2 * i + 1) / 2;
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(value);

                if (j <= breakpoint) {
                    value += 1;
                } else {
                    value -= 1;
                }
            }

            // Spaces
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
