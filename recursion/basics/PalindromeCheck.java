package recursion.basics;

import java.util.ArrayList;

public class PalindromeCheck {
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

    public static boolean palindromeCheck(String s) {
        ArrayList<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }

        ArrayList<Character> reversedCharacters = reverseString(charList);

        String reverseStr = "";
        for (char c : reversedCharacters) {
            reverseStr += c;
        }

        return s.equals(reverseStr);
    }

    public static void main(String[] args) {
        System.out.println(palindromeCheck("hannah"));
    }
}
