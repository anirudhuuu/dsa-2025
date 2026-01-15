package bit_manipulation.problems;

import java.util.Scanner;

/*
 * Binary representation of given number
 * --------------------------------------------------
 * Given an integer n, the task is to print the binary
 * representation of the number.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(log N)
 */
public class BinaryRepresentation01 {
    String binaryRepresentation(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            if (n % 2 == 1) {
                result.append("1");
            } else {
                result.append("0");
            }

            n = n / 2;
        }

        result.reverse();

        return result.toString();
    }

    static void main() {
        System.out.println("Enter the number to convert :: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Binary representation :: " + new BinaryRepresentation01().binaryRepresentation(n));
    }
}
