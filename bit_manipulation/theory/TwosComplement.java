package bit_manipulation.theory;

/**
 * Twos Complement
 * ==================
 * Given a binary number as a string, this class provides a method to compute
 * its two's complement. The two's complement is a mathematical operation that
 * represents the negation of a binary number in computing.
 * 
 * Time Complexity: O(n) — two passes over the string: one for 1’s complement,
 * one for adding 1.
 * 
 * Space Complexity: O(n) — for storing intermediate and final results using
 * StringBuilder.
 */
class TwosComplement {
    String twosComplement(String number) {
        StringBuilder onesComplement = new StringBuilder();

        // convert number to ones complement
        for (char ch : number.toCharArray()) {
            onesComplement.append(ch == '0' ? '1' : '0');
        }

        // add '1' to the ones complement
        StringBuilder result = new StringBuilder();
        boolean carry = true;

        for (int i = onesComplement.length() - 1; i >= 0; i--) {
            char bit = onesComplement.charAt(i);

            if (bit == '1' && carry) {
                result.append('0');
            } else if (bit == '0' && carry) {
                result.append('1');
                carry = false;
            } else {
                result.append(bit);
            }
        }

        result.reverse();

        return result.toString();
    }
}
