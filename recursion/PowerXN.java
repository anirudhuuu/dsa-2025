package recursion;

/**
 * Pow(x,n)
 * =========
 * Implement the power function pow(x, n),
 * which calculates the x raised to n i.e. x^n.
 */
public class PowerXN {
    public static double myPowBrute(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -1 * n;
        }

        double answer = 1.0;
        for (int i = 0; i < n; i++) {
            answer = answer * x;
        }

        return answer;
    }

    public static double myPowBetter(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        long number = n;
        if (n < 0) {
            x = 1 / x;
            number = -1 * number;
        }

        double answer = 1.0;

        while (number > 0) {
            if (number % 2 == 1) {
                answer = answer * x;
                number = number - 1;
            } else {
                x = x * x;
                number = number / 2;
            }
        }

        return answer;
    }

    public static double myPow(double x, int n) {
        long number = n;
        if (n < 0) {
            x = 1.0 / x;
            number = -1 * number;
        }

        if (number == 0) {
            return 1.0;
        }

        if (number % 2 == 1) {
            return x * myPow(x, (int) (number - 1));
        }

        return myPow(x * x, (int) (number / 2));
    }

    public static void main(String[] args) {
        // using inbuilt method
        int x = 5;
        int n = -2;

        System.out.println(Math.pow(x, n));

        // brute force
        System.out.println(myPowBrute(x, n));

        // better approach
        System.out.println(myPowBetter(x, n));

        // best approach
        System.out.println(myPow(x, n));
    }
}
