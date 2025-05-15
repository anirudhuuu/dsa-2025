package bit_manipulation.theory;

/**
 * Decimal to Binary
 * ==================
 * Given a decimal (base-10) integer, convert it to its
 * binary (base-2) representation as a string.
 * 
 * Implement a method that takes an integer input and
 * returns its binary equivalent.
 * 
 * Time Complexity: O(log₂N) — because you're dividing n by 2 in each
 * iteration.
 * 
 * Space Complexity: O(log₂N) — to store the binary digits in the
 * StringBuilder.
 */
class DecimalToBinary {
    String convertDecimalToBinary(int number) {
        StringBuilder result = new StringBuilder();
        int n = number;

        while (n != 0) {
            result.append(n % 2);
            n = n / 2;
        }

        return result.reverse().toString();
    }
}
