package basics.language;

/**
 * Given two integers X and N, print the value X on
 * the screen N times. Move to the next line after printing, even if N = 0.
 */
public class PrintXNoNTimes {
    public void printX(int X, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(X + " ");
        }
        System.out.println();
    }
}
