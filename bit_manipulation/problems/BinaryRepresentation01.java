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

        String result = "";

        while (n > 0) {
            result = (n % 2) + result;
            n = n / 2;
        }

        return result;
    }

    static void main() {
        System.out.println("Enter the number to convert :: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Binary representation :: " + new BinaryRepresentation01().binaryRepresentation(n));
    }
}
