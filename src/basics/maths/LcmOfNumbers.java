package basics.maths;

/**
 * You are given two integers n1 and n2. You need find the Lowest Common Multiple (LCM) of
 * the two given numbers. Return the LCM of the two numbers.
 * <p>
 * The Lowest Common Multiple (LCM) of two integers is the lowest positive integer that
 * is divisible by both the integers.
 */
public class LcmOfNumbers {
    /**
     * Time Complexity: O(n1 * n2)
     * Space Complexity: O(1)
     */
    int LCMBrute(int n1, int n2) {
        int i = 1;
        int maxNumber = Math.max(n1, n2);

        do {
            int multiple = i * maxNumber;

            if (multiple % n1 == 0 && multiple % n2 == 0) {
                return multiple;
            }

            i = i + 1;
        } while (true);
    }

    int GCD(int n1, int n2) {
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

    /**
     * Time Complexity: O(log (min(n1, n2)) )
     * Space Complexity: O(1)
     */
    int LCM(int n1, int n2) {
        return (n1 * n2) / GCD(n1, n2);
    }
}
