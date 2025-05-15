package bit_manipulation.theory;

/**
 * Ones Complement
 * ==================
 * Given a binary number as a string, this class provides
 * a method to compute its one's complement.
 * 
 * Time Complexity: O(n) — where n is the length of the input string
 * each character is processed once.
 * 
 * Space Complexity: O(n) — for the StringBuilder storing the output.
 */
class OnesComplement {
    String onesComplement(String number) {
        StringBuilder result = new StringBuilder();

        for (char ch : number.toCharArray()) {
            result.append(ch == '0' ? '1' : '0');
        }

        return result.toString();
    }
}
