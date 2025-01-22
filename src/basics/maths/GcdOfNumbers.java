package basics.maths;

/**
 * You are given two integers n1 and n2. You need find the
 * Greatest Common Divisor (GCD) of the two given numbers. Return
 * the GCD of the two numbers.
 * <p>
 * The Greatest Common Divisor (GCD) of two integers is the largest
 * positive integer that divides both of the integers.
 */
public class GcdOfNumbers {
    public int GCDEuclidean(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                // n1 = n1 - n2; to reduce the no of iterations
                n1 = n1 % n2;
            } else {
                // n2 = n2 - n1; to reduce the no of iterations
                n2 = n2 % n1;
            }
        }

        if (n2 == 0) {
            return n1;
        } else {
            return n2;
        }
    }

    public int GCDBrute(int n1, int n2) {
        int largest = 1;

        for (int i = 2; i < Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                largest = i;
            }
        }

        return largest;
    }
}
