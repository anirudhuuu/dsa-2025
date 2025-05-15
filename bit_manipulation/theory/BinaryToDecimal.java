package bit_manipulation.theory;

/**
 * Binary to Decimal
 * ==================
 * Given a binary (base-2) number as a string, convert it to its
 * decimal (base-10) integer representation.
 * 
 * Implement a method that takes a binary string input and
 * returns its decimal equivalent as an integer.
 * 
 * Time Complexity: O(n) — one loop through n characters of the string
 * 
 * Space Complexity: O(1) — only a few variables used, no extra space based
 * on input size
 */
class BinaryToDecimal {
    int convertBinaryToDecimal(String number) {
        int result = 0;
        int power = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            result += (number.charAt(i) - '0') * Math.pow(2, power);
            power += 1;
        }

        return result;
    }
}
