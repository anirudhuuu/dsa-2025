package recursion.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reverse a String I
 * =====================
 * Given an input string as an array of characters, write a function that
 * reverses the string.
 */
public class ReverseString {
    public static void reverse(ArrayList<Character> s, int left, int right) {
        if (left >= right) {
            return;
        }

        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);

        reverse(s, left + 1, right - 1);
    }

    public static ArrayList<Character> reverseString(ArrayList<Character> s) {
        int left = 0;
        int right = s.size() - 1;

        reverse(s, left, right);

        return s;
    }

    public static void main(String[] args) {
        List<Character> input = Arrays.asList('h', 'e', 'l', 'l', 'o');
        ArrayList<Character> formattedInput = new ArrayList<>(input);
        System.out.println(reverseString(formattedInput));
    }
}
