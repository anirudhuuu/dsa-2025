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
 * Example
 * ---------
 * Input: 10
 * Output: "1010"
 * 
 * Input: 7
 * Output: "111"
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
