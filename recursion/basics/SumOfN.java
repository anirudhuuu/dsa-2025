package recursion.basics;

/**
 * Sum of First N Numbers
 * ========================
 * Given an integer N, return the sum of first N natural numbers. Try to solve
 * this using recursion.
 */
public class SumOfN {
    // Brute force
    public static int NnumbersSumBrute(int N) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum = sum + i;
        }

        return sum;
    }

    // Recursive method
    public static int NnumbersSum(int N) {
        if (N == 1) {
            return 1;
        }

        return N + NnumbersSum(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(NnumbersSum(4));
    }
}
