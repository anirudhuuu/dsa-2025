package arrays.leetcode;

/**
 * Reverse String
 * ===============
 * Write a function that reverses a string. The input string is
 * given as an array of characters s.
 * 
 * You must do this by modifying the input array
 * in-place with O(1) extra memory.
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i += 1;
            j -= 1;
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] input = { 'h', 'e', 'l', 'l', 'o' };

        reverseString(input);
    }
}
