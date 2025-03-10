package arrays.medium;

/**
 * Given the row number r and the column number c,
 * find out the element at position (r , c).
 */
public class PascalsTriangle1 {
    // Brute force
    int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /**
     * Formula of math
     * ==================
     * nCr = n! / (r! * (n - r)!)
     */
    long nCrBrute(int n, int r) {
        int numerator = factorial(n);
        int denominator1 = factorial(r);
        int denominator2 = factorial(n - r);

        return (numerator) / ((long) denominator1 * denominator2);
    }

    long getPascalNumberBrute(int r, int c) {
        return nCrBrute(r - 1, c - 1);
    }

    // Optimised solution
    long nCr(int n, int r) {
        if (r > (n - r)) {
            r = n - r;
        }

        long result = 1;

        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }

    long getPascalNumber(int r, int c) {
        return nCr(r - 1, c - 1);
    }
}
